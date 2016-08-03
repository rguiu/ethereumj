package org.ethereum.validator;

import org.ethereum.core.BlockHeader;
import org.spongycastle.util.encoders.Hex;

import java.util.Arrays;

/**
 * Check that the block doesn't belong to HF blockchain
 *
 * Block 192000 in HF Chain have 0x4985f5ca3d2afbec36529aa96f74de3cc10a2a4a6c44f2157a57d2c6059a11bb hash,
 * but in Classic Chain it's 0x94365e3a8c0b35089c1d1195081fe7489b528a84b22199c916180db8b28ade7f
 *
 * @author Igor Artamonov
 */
public class HardForkRule extends BlockHeaderRule {

    private static final byte[] hfHash = Hex.decode("4985f5ca3d2afbec36529aa96f74de3cc10a2a4a6c44f2157a57d2c6059a11bb");

    @Override
    public boolean validate(BlockHeader header) {
        if  (header.getNumber() == 1_920_000) {
            return !Arrays.equals(header.getHash(), hfHash);
        }
        return true;
    }

}
