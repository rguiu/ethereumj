package org.ethereum.validator;

import org.ethereum.core.Block;
import org.junit.Test;
import org.spongycastle.util.encoders.Hex;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Igor Artamonov
 */
public class HardForkRuleTest {

    private HardForkRule rule = new HardForkRule();

    @Test
    public void test_1_920_000_HF() {
        byte[] rlp = Hex.decode(
            "f903cdf9020da0a218e2c611f21232d857e3c8cecdcdf1f65f25a4477f98f6f4" +
            "7e4063807f2308a01dcc4de8dec75d7aab85b567b6ccd41ad312451b948a7413" +
            "f0a142fd40d4934794bcdfc35b86bedf72f0cda046a3c16829a2ef41d1a0c5e3" +
            "89416116e3696cce82ec4533cce33efccb24ce245ae9546a4b8f0d5e9a75a077" +
            "01df8e07169452554d14aadd7bfa256d4a1d0355c1d174ab373e3e2d0a3743a0" +
            "26cf9d9422e9dd95aedc7914db690b92bab6902f5221d62694a2fa5d065f534b" +
            "b901000000000000000000000000000000000000000000000000000000000000" +
            "0000000000000000000000000000000000000000000000000000000000000000" +
            "0000000000000000000000000000000000000000000000000000000000000000" +
            "0000000000000000000000000000000000000000000000000000000000000000" +
            "0000000000000000000000000000000000000000000000000000000000000000" +
            "0000000000000000000000000000000000000000000000000000000000000000" +
            "0000000000000000000000000000000000000000000000000000000000000000" +
            "0000000000000000000000000000000000000000000000000000000000000000" +
            "0000008638c3bf2616aa831d4c008347e7c08301482084578f7aa88d64616f2d" +
            "686172642d666f726ba05b5acbf4bf305f948bd7be176047b20623e1417f7559" +
            "7341a059729165b9239788bede87201de42426f901b9f86c018504a817c80082" +
            "52089453d284357ec70ce289d6d64134dfac8e511c8a3d8814da2c24e0d37014" +
            "801ba0fdbbc462a8a60ac3d8b13ee236b45af9b7991cf4f0f556d3af46aa5aec" +
            "a242aba05de5dc03fdcb6cf6d14609dbe6f5ba4300b8ff917c7d190325d9ea21" +
            "44a7a2fbf86c018504a817c8008252089453d284357ec70ce289d6d64134dfac" +
            "8e511c8a3d888b6cfa3afc058000801ba08d94a55c7ac7adbfa2285ef7f4b0c9" +
            "55ae1a02647452cd4ead03ee6f449675c6a067149821b74208176d78fc4dffbe" +
            "37c8b64eecfd47532406b9727c4ae8eb7c9af86d018504a817c8008252089453" +
            "d284357ec70ce289d6d64134dfac8e511c8a3d890116db7272d6d94000801ca0" +
            "6d31e3d59bfea97a34103d8ce767a8fe7a79b8e2f30af1e918df53f9e78e69ab" +
            "a0098e5b80e1cc436421aa54eb17e96b08fe80d28a2fbd46451b56f2bca7a321" +
            "e7f86c018504a817c8008252089453d284357ec70ce289d6d64134dfac8e511c" +
            "8a3d880e301365046d5000801ba0bafb9f71cef873b9e0395b9ed89aac4f2a75" +
            "2e2a4b88ba3c9b6c1fea254eae73a01cef688f6718932f7705d9c1f0dd5a8aad" +
            "9ddb196b826775f6e5703fdb997706c0");
        Block b = new Block(rlp);
        assertFalse(rule.validate(b.getHeader()));
    }

    @Test
    public void test_1_920_000_CLASSIC() {
        byte[] rlp = Hex.decode(
            "f903cff9020fa0a218e2c611f21232d857e3c8cecdcdf1f65f25a4477f98f6f4" +
                "7e4063807f2308a01dcc4de8dec75d7aab85b567b6ccd41ad312451b948a7413" +
                "f0a142fd40d493479461c808d82a3ac53231750dadc13c777b59310bd9a0614d" +
                "7d358b03cbdaf0343529673be20ad45809d02487f023e047efdce9da8affa0d3" +
                "3068a7f21bff5018a00ca08a3566a06be4196dfe9e39f96e431565a619d455a0" +
                "7bda9aa65977800376129148cbfe89d35a016dd51c95d6e6dc1e76307d315468" +
                "b901000000000000000000000000000000000000000000000000000000000000" +
                "0000000000000000000000000000000000000000000000000000000000000000" +
                "0000000000000000000000000000000000000000000000000000000000000000" +
                "0000000000000000000000000000000000000000000000000000000000000000" +
                "0000000000000000000000000000000000000000000000000000000000000000" +
                "0000000000000000000000000000000000000000000000000000000000000000" +
                "0000000000000000000000000000000000000000000000000000000000000000" +
                "0000000000000000000000000000000000000000000000000000000000000000" +
                "0000008638c3bf2616aa831d4c008347e7c08301482084578f7aa78fe4b883e5" +
                "bda9e7a59ee4bb99e9b1bca0c52daa7054babe515b17ee98540c0889cf5e1595" +
                "c5dd77496997ca84a68c8da18805276a600980199df901b9f86c018504a817c8" +
                "008252089453d284357ec70ce289d6d64134dfac8e511c8a3d888b6cfa3afc05" +
                "8000801ba08d94a55c7ac7adbfa2285ef7f4b0c955ae1a02647452cd4ead03ee" +
                "6f449675c6a067149821b74208176d78fc4dffbe37c8b64eecfd47532406b972" +
                "7c4ae8eb7c9af86d018504a817c8008252089453d284357ec70ce289d6d64134" +
                "dfac8e511c8a3d890116db7272d6d94000801ca06d31e3d59bfea97a34103d8c" +
                "e767a8fe7a79b8e2f30af1e918df53f9e78e69aba0098e5b80e1cc436421aa54" +
                "eb17e96b08fe80d28a2fbd46451b56f2bca7a321e7f86c018504a817c8008252" +
                "089453d284357ec70ce289d6d64134dfac8e511c8a3d8814da2c24e0d3701480" +
                "1ba0fdbbc462a8a60ac3d8b13ee236b45af9b7991cf4f0f556d3af46aa5aeca2" +
                "42aba05de5dc03fdcb6cf6d14609dbe6f5ba4300b8ff917c7d190325d9ea2144" +
                "a7a2fbf86c018504a817c8008252089453d284357ec70ce289d6d64134dfac8e" +
                "511c8a3d880e301365046d5000801ba0bafb9f71cef873b9e0395b9ed89aac4f" +
                "2a752e2a4b88ba3c9b6c1fea254eae73a01cef688f6718932f7705d9c1f0dd5a" +
                "8aad9ddb196b826775f6e5703fdb997706c0");
        Block b = new Block(rlp);
        assertTrue(rule.validate(b.getHeader()));
    }

    @Test
    public void test_1_919_999() {
        byte[] rlp = Hex.decode(
            "f9020bf90206a0505ffd21f4cbf2c5c34fa84cd8c92525f3a719b7ad18852bff" +
                "ddad601035f5f4a01dcc4de8dec75d7aab85b567b6ccd41ad312451b948a7413" +
                "f0a142fd40d49347942a65aca4d5fc5b5c859090a6c34d164135398226a0fdf2" +
                "fc04580b95ca15defc639080b902e93892dcce288be0c1f7a7bbc778248ba056" +
                "e81f171bcc55a6ff8345e692c0f86e5b48e01b996cadc001622fb5e363b421a0" +
                "56e81f171bcc55a6ff8345e692c0f86e5b48e01b996cadc001622fb5e363b421" +
                "b901000000000000000000000000000000000000000000000000000000000000" +
                "0000000000000000000000000000000000000000000000000000000000000000" +
                "0000000000000000000000000000000000000000000000000000000000000000" +
                "0000000000000000000000000000000000000000000000000000000000000000" +
                "0000000000000000000000000000000000000000000000000000000000000000" +
                "0000000000000000000000000000000000000000000000000000000000000000" +
                "0000000000000000000000000000000000000000000000000000000000000000" +
                "0000000000000000000000000000000000000000000000000000000000000000" +
                "0000008638bca78f24c6831d4bff8347d5cc8084578f7aa6894477617266506f" +
                "6f6ca0a0230af0a0d3d297b7e8c2473d163b1eb0b1bbbb4e9d933e5fdea08546" +
                "b56e598860832709c8979daac0c0");
        Block b = new Block(rlp);
        assertTrue(rule.validate(b.getHeader()));
    }

    @Test
    public void test_1_920_001() {
        byte[] rlp = Hex.decode(
            "f913aef90213a094365e3a8c0b35089c1d1195081fe7489b528a84b22199c916180db8b28ade7fa01dcc4de8dec75d7aab85b567b6ccd41ad312451b948a7413f0a142fd40d4934794ea674fdde714fd979de3edf0f56aa9716b898ec8a04fa44963d11627f4c66915ac3e54ba2e20a39bfca9375da49ef9ac84804417aca0671f05604731351ed09c653eb2257eca620f0ac5caed47e6a196cf1131d7ba8ea07d74148d2c93e5c5c3ef2807ea7b396cb84b3149d0c1fd7e5294e43043bc3855b90100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000008638b58e384d26831d4c018347e7c4830d4ec884578f7acd9365746865726d696e652e6f7267202855533129a006da5423d0cb430668b312b4184c8028dfaa0796eb58b13154ff8d13107b48e088f27436600f4bf6c4f91194f86c808504e3b29200825208940bf59e61873ce3f3e8dbb85ff759a84bde0b0d24880c9b6ed273300000801ba01759649367d944956f348d3673c41b47e722a552c82c44b65952bbb7ac4d3580a0732a13fc6ed43ea3c8bed4db60bd3c4e08c9524618640e8f000d67c25632b3abf86c018504a817c8008252089453d284357ec70ce289d6d64134dfac8e511c8a3d880e58845d20e17400801ca06a93c12e7519d6ddcd9245042c600ea38f7d5bf8a472a11c0613fd09e7d98db5a013820cd9564650ea58096e641b08103fe3a5592f5fc8515bef28732782b3d1eff86c018504a817c8008252089453d284357ec70ce289d6d64134dfac8e511c8a3d880ddf38b6c895c000801ba0c2e10505e33a01965fc3225ffc7abb33469172926973f6605127b6899d972b22a028964b4c4150d308e6b76d383d94e1722e06bd80bf4387d7bbc38749d4b08bdef86d018504a817c8008252089453d284357ec70ce289d6d64134dfac8e511c8a3d895150ad06abef21c000801ba07d3f833e158154a52a97c3e60aee42f5aeec4a85d985646d5320987ba6397f28a0315cc7185847e80f90ae65d9124b4055f7414274a67f1b919eca0cbf1b7e2772f86c018504a817c8008252089453d284357ec70ce289d6d64134dfac8e511c8a3d880ed9978d63ef1800801ba0d7311b43aae463690b008dbc200017cbe25b072fc5d0a510e1e4d319f3f284e9a050ba02cd5fce7a5d8b0ba5d4edd4e5d8f29fe949e6624396862f5ab6b46a3a08f86c018504a817c8008252089453d284357ec70ce289d6d64134dfac8e511c8a3d88c76c7054b10c7d94801ba00818f999dad85b33e6596a73b14ea4a190ed35b045107860c83823a517cddccfa075d49d4f650f65a682345b5b17254f77550c05aabd3f002dbbb6a95407a0d0d4f86d018504a817c8008252089453d284357ec70ce289d6d64134dfac8e511c8a3d8905f88302cf00ed0000801ba05220406d9ecb6882c4cb6d91d07ad1de2af0a08d7f91fd1b463db633352248baa051fc5a4756b3cc8b8d32a2402835f35190bdca8de97206b522c331db4bf0c107f86c018504a817c8008252089453d284357ec70ce289d6d64134dfac8e511c8a3d8801aaedbb95679400801ca03b899fe1f33c677b9982c839d2cb66e51ff75e68a8481ada8de9751e5d51417aa016b372fdbe0b2e4f9caf0cf22c635429bc5fcd4b008bb6ec75b34f72f3d4c0b4f86d018504a817c8008252089453d284357ec70ce289d6d64134dfac8e511c8a3d8901fdf66ec48af38000801ca0230d1d34233847ded85aaa0d0a61ef1e12c6b2eca1fa9d5c326adfd5b1c2ec28a01f8ee6f90fd19d498239047650e67e1b88ca3d58f0be52c3921f241e8ec540f2f86b018504a817c8008252089453d284357ec70ce289d6d64134dfac8e511c8a3d8728410c43b87000801ba043a7279ba82ec520b38310e6c9c0645298bdc5a145437562341a19056ea4191ea003c2a693e4fd4a99491ce966278f4b51684f8e98051713b2f0d1134810afaaabf86c018504a817c8008252089453d284357ec70ce289d6d64134dfac8e511c8a3d8801b65e0bb7194f70801ba0c7f05287ed48f184ee84b547ca1550b934e22e5240a6e442b2637897b8ec8082a04494c19f74eb14ec9a85f8cf9efb3b87c125b873922ca4a9c1a856e3947e5ea4f86c018504a817c8008252089453d284357ec70ce289d6d64134dfac8e511c8a3d880e470f558d9d9800801ca045519277d28456bdfa0ca28e329442fe126a781b662db101b4c59c8b6b1c89a9a03dc613721f2e8e4cae68fdbbc977bef01d55847b96fb374f91147cd69b6065aaf86c018504a817c8008252089453d284357ec70ce289d6d64134dfac8e511c8a3d880e2a6587eb915800801ba0ea2e565145354721e7a1481f037b1e27a752d98254d2037cba8bd896b26fea33a0404be1a094b8ab7493cd5c469a8aea3673a33c681c8a71c9e50597a69fee3d68f86b018504a817c8008252089453d284357ec70ce289d6d64134dfac8e511c8a3d8766df9c4b8e5c00801ba00d77e2626a8bb0eb2211f3389207dab19940486cb747691203e2a178cf5bb0bea020cd7753c78eb24ce2f4fd132e5ca71a06cbce391f19eac4483f0cbcfe7bdaa0f86c018504a817c8008252089453d284357ec70ce289d6d64134dfac8e511c8a3d88a687126ef9e1c000801ba0d4f37a8b8f16c2ea811b3f33c16664b9fe633db9eabf96fa5b026874cd37fdc2a0711e2c3399ef261b8ac4e5925900699f8b1ffbd2f853d6dbc9906302b4cfc9f9f86c018504a817c8008252089453d284357ec70ce289d6d64134dfac8e511c8a3d881c2adb865c8c1fc0801ca01084bb9c842d77e5e67b285dc531bd8413b7ae542570cbc930e485bc001d163da0034622009362c61ca43290fab784e8a4125a2c570dfec9fe53579b151aae2d68f86b808504a817c8008252089453d284357ec70ce289d6d64134dfac8e511c8a3d879b0e67b6b6b800801ca0413aa0ea220945e0e75e0e340c60638b411624ca83efca6efdcb5f1b45ab8462a0320f651d207785dec44f42bc53aabb9f0df2146dbf7801ab52e2e44b70c86eeef86c018504a817c8008252089453d284357ec70ce289d6d64134dfac8e511c8a3d887e205c78596ff000801ca07b05a610382be7fcc5ed04312939d5b4418b473ebf49c4238b5bc0d4e48fc67fa0526fae5807156b28d35433675ff43f5565cfcd5e9ac749e16bfbdb176974b7baf86c018504a817c8008252089453d284357ec70ce289d6d64134dfac8e511c8a3d8814d1ba83e7287b28801ca05d7eb16e50515a15c0c033fd53db25e8426cee452b811aa5c6b70ab1a8dacd38a0181ca09318ee749af67d3012ffe1ff9409c50d845102c313304113af987cf2c2f86c018504a817c8008252089453d284357ec70ce289d6d64134dfac8e511c8a3d880a663eefafdb6220801ca0c8da4cffec3795161b284739d634b0bfc19b10159fed9dec7d955c3849d79d6ea03a2ddbd5263ba5077074112221fc31ae80e71213d4c5f64855a338256d317892f86c018504a817c8008252089453d284357ec70ce289d6d64134dfac8e511c8a3d880de46534dddfb4fc801ca0bcc75e90949ad52afac669f0564972de359b4bbfa5a0e8c45ff04479e894f3eca0114a9b30d6d15400fd53f7db42b7e801a7943e23e2a7680a3ad458cd93edd9d9f86c018504a817c8008252089453d284357ec70ce289d6d64134dfac8e511c8a3d880de64551ca29a428801ba0e5a5507b0244ba718af07b930eb6de528b1981f076d52f8dd7cdbbeeca46ad43a0435fea10340170a7bb440027ee2cf8ab3d96fe01c5e176eb678f993e07359ce3f86c018504a817c8008252089453d284357ec70ce289d6d64134dfac8e511c8a3d8801c92f87cbe35860801ca0b41afb629f44c91409c383543cc5501a4f031e1b82f65e43e62de4547cbde010a07ba4e4c85d73ded977436994ba175b6312938c43355ff2b706d54e60e81812e9f86c018504a817c8008252089453d284357ec70ce289d6d64134dfac8e511c8a3d8802ec106ee7acdae0801ba0fd1ae0745afc4793bcfd0e00ea0c0bdb25d69b0b217ff4cee2b729da11801dd2a073d22a4d2cd13ec103ab558b04c360626e10037219bc062781d875f2490184f2f86c018504a817c8008252089453d284357ec70ce289d6d64134dfac8e511c8a3d880f8c51aa5c481f40801ca016e8048f7ba10f131247d8b05296dc7460fd958351f147e5d915ab966e4ce8d1a043d5ef8774fc72f484af7955c8b237b94376bf90daa4bcaadf5248f1e0206676f86c018504a817c8008252089453d284357ec70ce289d6d64134dfac8e511c8a3d8801379acc4c3bb000801ca028be39af22590521182f02f9fe28501e3f49cf134633b5206c8582877dd9d7c2a02151a95369bdd77d5e2fd420bfec33fbe7f4032f99937952f7ac5c0b45899bb5f86c018504a817c8008252089453d284357ec70ce289d6d64134dfac8e511c8a3d8829adb75405b70128801ca09d8ed9ca03fa5666e8f44fd3f1563bc5d1aa6abaf6609891af870d6fd407a2a3a05864b5ddd20a5e4048bae0ac31876946bfe2bac950a6619c25843a0489078fdcf86b018504a817c8008252089453d284357ec70ce289d6d64134dfac8e511c8a3d8728410c43b87000801ba047c4c309aee54f5c3c5cf6a9097cac1059730fea5f2fa3fcaa5e1e87d486b045a064da718538303473bd63d0ea62460036e6d1e976603014e753d647f6bee21b09f86c018504a817c8008252089453d284357ec70ce289d6d64134dfac8e511c8a3d8801379acc4c3bb000801ca0294a9c417e15d9df0868537c51abb05b0ec62d58341feaad2c8a3951587b6f79a06eafa5a42c33ec1165ec98e40c8c85cc90439556cc075c5ac559b4ea29dba957f86c018504a817c8008252089453d284357ec70ce289d6d64134dfac8e511c8a3d880316c715b9193e50801ca00155df1fe0bc245753e749f0c3b693bcccc0f47fac5282a11a972bfce5bdf020a020f62e2a3d4c2432455a1f1bab78225c8468e58bf7a8e6acd2f9a194ffbb0788f8680a8504a817c800829c4094b5a7f4ea27e362c57d41b942392f1a46548680468084a2e620451ca05f855b937329f27b66e96d010e47eb2e4e18c520153a57f1ed7844b2d4bf408ea01814596cfecdc7fc1ca4e212131a1d6a4e176269154f642d2b62ebdc53094d7cf86c018504a817c8008252089453d284357ec70ce289d6d64134dfac8e511c8a3d880ddf7c8b0d965e04801ba0af2dc414b9da1dd9c707c98d070d8646cdd72f77e644af86c1a4486452085788a018316827e6415ddc54f3b12dde86374d8d2e4cd4fe76c8c4a0ac194eea62aaa2f8680b8504a817c800829c40942bd2326c993dfaef84f696526064ff22eba5b3628084a2e620451ca06e699dcfa4b7cc7da44fdd37c0a7e6e4665e57cd0bf9b38f165614546195a7f2a0636109c27628c19e4d574fec906d2831bc71c6ef45cb50974d4f0aa729d76382f86c018504a817c8008252089453d284357ec70ce289d6d64134dfac8e511c8a3d8801c2725e032acc80801ba00cf3a45ed04b8467808b54bce3d40deabf147d4876fe90d78f1e63466577c9a0a064c990e36e7360820dc995ef13c3fd087a042708eb046e7ff89cec8add873a36f86c018504a817c8008252089453d284357ec70ce289d6d64134dfac8e511c8a3d880de2aed4152181fc801ca0a4f805dbf6d47c2009c6a13fd0854a226795de2ff746e532cba08997c89ac891a039d4e0293fada9282d44f7c021aa0faabcdd51d5cb2d3f6f1702a0f8c324b59ff86c018504a817c8008252089453d284357ec70ce289d6d64134dfac8e511c8a3d8829d59f15be7fbe90801ca00ec3f3f8f6769ccfc4ff124898783a3f90dad4249b5e8ef703010d9779cbc9c0a015f5c85f8d4e950646b3bef0fa9a125bda44251e42249c830831aed053d4ed7ff86b018504a817c8008252089453d284357ec70ce289d6d64134dfac8e511c8a3d8728410c43b87000801ca06b9fefb922297c47ae9ad953d1ec9e60c5dca998cee74b0cdcaccca78284e02ea0579f9646bed9f5e1e73c950e7d8721626fe45cbcbd3367cbd719c1489a6a43e0f86c018504a817c8008252089453d284357ec70ce289d6d64134dfac8e511c8a3d8801de96f0d6567000801ca0b761fc5af0f9a2ee49139e9b993f3c6a53af2be2efae1fde155f4f9ddc98bb3da06070f46269ae178aaadde6b0983de6cfb57bad99f6503523cbdddf5388f33115f86b018504a817c8008252089453d284357ec70ce289d6d64134dfac8e511c8a3d873d2090d4fbc800801ba0079dc0cdf572a7d3ef1961c396256d453b0a24d0fca6304486ae8d7a13c127ffa036f59317f84f17873733ce43fca1c896b234a5825ec408b5c819f4f9b3848180f86d018504a817c8008252089453d284357ec70ce289d6d64134dfac8e511c8a3d890a9fe20e38f1c76400801ba0152f759444a9693dc4ace9da99ed19e4107ad0f1fa62351e793c380360537876a03e8312e3750d45d259bbdf7a90cb720ae7d8de4cd79bfd6b8abeba3e7a528aa2f86c018504a817c8008252089453d284357ec70ce289d6d64134dfac8e511c8a3d8801822d0797de0f00801ca0abccfa4683d3a8dfe947c78f8ef0d2ac857685f29288c1e37ca5b279d2454edca0318d8586f9ad7a2b7d0dc1b74b387f554cd248cd389edc12c5e48172fa940c56c0");
        Block b = new Block(rlp);
        assertTrue(rule.validate(b.getHeader()));
    } 
}