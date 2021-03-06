package org.ethereum.datasource;

import static org.ethereum.util.ByteUtil.wrap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.ethereum.db.ByteArrayWrapper;
import org.iq80.leveldb.DBException;
import net.openhft.chronicle.map.ChronicleMap;

public class HashMapDB implements KeyValueDataSource {

    ChronicleMap<ByteArrayWrapper,  ByteArrayWrapper> storage = ChronicleMap
            .of(ByteArrayWrapper.class, ByteArrayWrapper.class)
            .averageKey(wrap("99db6f4f5fea3aa5cfbe8436feba8e213d06d1e8".getBytes()))
            .averageValueSize(64000)
            .entries(50_000)
            .create();

    private boolean clearOnClose = true;

    @Override
    public void delete(byte[] arg0) throws DBException {
        storage.remove(wrap(arg0));
    }

    @Override
    public byte[] get(byte[] arg0) throws DBException {
        try {
            return storage.get(wrap(arg0)).getData();
        } catch (NullPointerException ne) {
            return null;
        }
    }

    @Override
    public byte[] put(byte[] key, byte[] value) throws DBException {
        try {
            return storage.put(wrap(key), wrap(value)).getData();
        } catch (NullPointerException ne) {
            return null;
        }
    }

    /**
     * Returns the number of items added to this Mock DB
     *
     * @return int
     */
    public int getAddedItems() {
        return storage.size();
    }

    @Override
    public void init() {

    }

    @Override
    public boolean isAlive() {
        return true;
    }

    @Override
    public void setName(String name) {

    }

    @Override
    public String getName() {
        return "in-memory";
    }

    @Override
    public Set<byte[]> keys() {
        Set<byte[]> keys = new HashSet<>();
        for (ByteArrayWrapper key : storage.keySet()){
            keys.add(key.getData());
        }
        return keys;
    }

    @Override
    public void updateBatch(Map<byte[], byte[]> rows) {
        for (byte[] key :  rows.keySet()){
            storage.put(wrap(key), wrap(rows.get(key)));
        }
    }

    public HashMapDB setClearOnClose(boolean clearOnClose) {
        this.clearOnClose = clearOnClose;
        return this;
    }

    @Override
    public void close() {
        if (clearOnClose) {
            this.storage.clear();
        }
    }
}