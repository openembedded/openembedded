require bash.inc

PR = "r8"

SRC_URI += "\
           file://builtins.patch;patch=1 \
           http://ftp.gnu.org/gnu/bash/bash-3.2-patches/bash32-001;patch=1;pnum=0;name=bash32-01 \
           http://ftp.gnu.org/gnu/bash/bash-3.2-patches/bash32-002;patch=1;pnum=0;name=bash32-02 \
           http://ftp.gnu.org/gnu/bash/bash-3.2-patches/bash32-003;patch=1;pnum=0;name=bash32-03 \
           http://ftp.gnu.org/gnu/bash/bash-3.2-patches/bash32-004;patch=1;pnum=0;name=bash32-04 \
           http://ftp.gnu.org/gnu/bash/bash-3.2-patches/bash32-005;patch=1;pnum=0;name=bash32-05 \
           http://ftp.gnu.org/gnu/bash/bash-3.2-patches/bash32-006;patch=1;pnum=0;name=bash32-06 \
           http://ftp.gnu.org/gnu/bash/bash-3.2-patches/bash32-007;patch=1;pnum=0;name=bash32-07 \
           http://ftp.gnu.org/gnu/bash/bash-3.2-patches/bash32-008;patch=1;pnum=0;name=bash32-08 \
           http://ftp.gnu.org/gnu/bash/bash-3.2-patches/bash32-009;patch=1;pnum=0;name=bash32-09 \
           http://ftp.gnu.org/gnu/bash/bash-3.2-patches/bash32-010;patch=1;pnum=0;name=bash32-10 \
           http://ftp.gnu.org/gnu/bash/bash-3.2-patches/bash32-011;patch=1;pnum=0;name=bash32-11 \
           http://ftp.gnu.org/gnu/bash/bash-3.2-patches/bash32-012;patch=1;pnum=0;name=bash32-12 \
           http://ftp.gnu.org/gnu/bash/bash-3.2-patches/bash32-013;patch=1;pnum=0;name=bash32-13 \
           http://ftp.gnu.org/gnu/bash/bash-3.2-patches/bash32-014;patch=1;pnum=0;name=bash32-14 \
           http://ftp.gnu.org/gnu/bash/bash-3.2-patches/bash32-015;patch=1;pnum=0;name=bash32-15 \
           http://ftp.gnu.org/gnu/bash/bash-3.2-patches/bash32-016;patch=1;pnum=0;name=bash32-16 \
           http://ftp.gnu.org/gnu/bash/bash-3.2-patches/bash32-017;patch=1;pnum=0;name=bash32-17 \
           http://ftp.gnu.org/gnu/bash/bash-3.2-patches/bash32-018;patch=1;pnum=0;name=bash32-18 \
           http://ftp.gnu.org/gnu/bash/bash-3.2-patches/bash32-019;patch=1;pnum=0;name=bash32-19 \
           http://ftp.gnu.org/gnu/bash/bash-3.2-patches/bash32-020;patch=1;pnum=0;name=bash32-20 \
           http://ftp.gnu.org/gnu/bash/bash-3.2-patches/bash32-021;patch=1;pnum=0;name=bash32-21 \
           http://ftp.gnu.org/gnu/bash/bash-3.2-patches/bash32-022;patch=1;pnum=0;name=bash32-22 \
           http://ftp.gnu.org/gnu/bash/bash-3.2-patches/bash32-023;patch=1;pnum=0;name=bash32-23 \
           http://ftp.gnu.org/gnu/bash/bash-3.2-patches/bash32-024;patch=1;pnum=0;name=bash32-24 \
           http://ftp.gnu.org/gnu/bash/bash-3.2-patches/bash32-025;patch=1;pnum=0;name=bash32-25 \
           http://ftp.gnu.org/gnu/bash/bash-3.2-patches/bash32-026;patch=1;pnum=0;name=bash32-26 \
           http://ftp.gnu.org/gnu/bash/bash-3.2-patches/bash32-027;patch=1;pnum=0;name=bash32-27 \
           http://ftp.gnu.org/gnu/bash/bash-3.2-patches/bash32-028;patch=1;pnum=0;name=bash32-28 \
           http://ftp.gnu.org/gnu/bash/bash-3.2-patches/bash32-029;patch=1;pnum=0;name=bash32-29 \
           http://ftp.gnu.org/gnu/bash/bash-3.2-patches/bash32-030;patch=1;pnum=0;name=bash32-30 \
           http://ftp.gnu.org/gnu/bash/bash-3.2-patches/bash32-031;patch=1;pnum=0;name=bash32-31 \
           http://ftp.gnu.org/gnu/bash/bash-3.2-patches/bash32-032;patch=1;pnum=0;name=bash32-32 \
           http://ftp.gnu.org/gnu/bash/bash-3.2-patches/bash32-033;patch=1;pnum=0;name=bash32-33 \
           http://ftp.gnu.org/gnu/bash/bash-3.2-patches/bash32-034;patch=1;pnum=0;name=bash32-34 \
           http://ftp.gnu.org/gnu/bash/bash-3.2-patches/bash32-035;patch=1;pnum=0;name=bash32-35 \
           http://ftp.gnu.org/gnu/bash/bash-3.2-patches/bash32-036;patch=1;pnum=0;name=bash32-36 \
           http://ftp.gnu.org/gnu/bash/bash-3.2-patches/bash32-037;patch=1;pnum=0;name=bash32-37 \
           http://ftp.gnu.org/gnu/bash/bash-3.2-patches/bash32-038;patch=1;pnum=0;name=bash32-38 \
           http://ftp.gnu.org/gnu/bash/bash-3.2-patches/bash32-039;patch=1;pnum=0;name=bash32-39 \
           file://default_path.patch;patch=1 \
           "

SRC_URI[archive.md5sum] = "00bfa16d58e034e3c2aa27f390390d30"
SRC_URI[archive.sha256sum] = "26c99025b59e30779300b68adb764f824974d267a4d7cc1b347d14a2393f9fb4"
SRC_URI[bash32-01.md5sum] = "d8e10c754f477e3f3a581af566b89301"
SRC_URI[bash32-01.sha256sum] = "beda60ce6186fafa36cd0a98db9ced42cff68daee4342cca73167fb0f2f43eaa"
SRC_URI[bash32-02.md5sum] = "d38a5288b2f0ea6c9ac76b66cc74ef7d"
SRC_URI[bash32-02.sha256sum] = "a0ca49a3c47678ad074c990bdc871fcec680749b7f04f2def6527f04c589c40a"
SRC_URI[bash32-03.md5sum] = "0b90d37911827d8cb95f3b4353cc225e"
SRC_URI[bash32-03.sha256sum] = "7ec9e5e7e402e43b12bfd3a9237f4f171029fc7f58e59335abf3ccb455a5a84d"
SRC_URI[bash32-04.md5sum] = "8062f3a59631f58d78b180d83759b68a"
SRC_URI[bash32-04.sha256sum] = "3de0938673637089c3b0f0f355de377bb2be2d3fca68053dda267ca11b5998f2"
SRC_URI[bash32-05.md5sum] = "585b5943fadf0875ced243b245adde58"
SRC_URI[bash32-05.sha256sum] = "e7fecdecb12320cd6fe9aca83fab1828b76aeb5313b991883764cb9139d845b7"
SRC_URI[bash32-06.md5sum] = "1d5732e01ea938aeed42f3def131fa4d"
SRC_URI[bash32-06.sha256sum] = "8f14f81ced32bc057bc10abf6842f4a5ac172816631f2b87a5a3be4f01c0847d"
SRC_URI[bash32-07.md5sum] = "dcd0cc5d801607827f7c851e72b0eabc"
SRC_URI[bash32-07.sha256sum] = "6863a712e5a68eccfb77162a9f947ffd80af648f0124c38f795ebba2be12eff8"
SRC_URI[bash32-08.md5sum] = "bb3c7dd11198c0ab93d0e960bebf6256"
SRC_URI[bash32-08.sha256sum] = "ccf303b4d199d89d5efc659235f8a645376e86d294260dda4becbb61ec06667b"
SRC_URI[bash32-09.md5sum] = "434a6f29b0ca5f1ab784b2437ae8eaed"
SRC_URI[bash32-09.sha256sum] = "ef30c579419106b4b4a2d0064ef7e57ceee6cdf657f4ccd7b89c8e4fd70560d8"
SRC_URI[bash32-10.md5sum] = "2efff04dd246fcf63bd4b99f77c9a081"
SRC_URI[bash32-10.sha256sum] = "bb7df9fefe88d62ee371353edf62402a667cffba6ea202aa1c8b220308a0c612"
SRC_URI[bash32-11.md5sum] = "1dd104342f6920dfaf5efb3131e922e0"
SRC_URI[bash32-11.sha256sum] = "85bf656cfc49b1447b061341a4b1cb93ba89a41d8d1699a65aa971d1853ba472"
SRC_URI[bash32-12.md5sum] = "4f24b696ab78bdfae4f9cb7eb59b835d"
SRC_URI[bash32-12.sha256sum] = "45ef4ad98f2f218aa3acec15842ae1b833769c1dbe2f90c9bba00bbe4949fc43"
SRC_URI[bash32-13.md5sum] = "7c40addbf1187a26ae1c8373ed383442"
SRC_URI[bash32-13.sha256sum] = "9fbf893c383f45d25e5bc5c9eae8d2b349521f288945b3bd21c781784b81f693"
SRC_URI[bash32-14.md5sum] = "28e88c9f8679e99ac590d4a4a8227c56"
SRC_URI[bash32-14.sha256sum] = "62bb1a4d70f6f7938ca70a6aa7fe6f4b377ab5f450c7756b22b41de3bbd98ed6"
SRC_URI[bash32-15.md5sum] = "7c17d29675bd0d49470f162774385f80"
SRC_URI[bash32-15.sha256sum] = "de40425e83628eb7431f39340ac09b42b5fcf484a565352851961b3e917d8771"
SRC_URI[bash32-16.md5sum] = "a1edaa98b4449fe2205fa75448b7b105"
SRC_URI[bash32-16.sha256sum] = "7abf66bbba3ebd6b6428190f3ebca59abdc0bfa3957f1a725489de7391c2d9f1"
SRC_URI[bash32-17.md5sum] = "889ed119bbf9d363660b9a0127f35efa"
SRC_URI[bash32-17.sha256sum] = "951aa2a07b38db8eea8e7368d3ac36af60af7f5ade455215006229ce3815dfe0"
SRC_URI[bash32-18.md5sum] = "a7d3f85fa687d2c1b5a134839f6d395d"
SRC_URI[bash32-18.sha256sum] = "c85e2bca6084a79774adbf801698c62905662836334e54355b77fbf1c529074c"
SRC_URI[bash32-19.md5sum] = "f0399da4007e46fc5820ce25d07425b9"
SRC_URI[bash32-19.sha256sum] = "d83f1d740cb103be444589dcd9da61c2802815e8c256a01cfa7e484c50a9eb85"
SRC_URI[bash32-20.md5sum] = "b76602281c3104d904fd064510fe0c21"
SRC_URI[bash32-20.sha256sum] = "3e66a1d05566d5501c2f868d3c94b8d71821a21d0daf9baaf594369697793013"
SRC_URI[bash32-21.md5sum] = "923374ae4403c92820f711e62e1d01a5"
SRC_URI[bash32-21.sha256sum] = "a5e54704e6867c969a3e60556a5fbacedecca7404c3ddbe8180a92b6898a2a58"
SRC_URI[bash32-22.md5sum] = "c82d3bd14e373878b2a680dce18d1596"
SRC_URI[bash32-22.sha256sum] = "057e03d593b858637056c0458b168e9c012db914727abba964afcaf377f2c5a4"
SRC_URI[bash32-23.md5sum] = "987c949a77b4b0ffe4a2597141e77635"
SRC_URI[bash32-23.sha256sum] = "869466d80807cde59c0eab9a39ef1909be4d5e8698ea1e3daa530ad59baaa97a"
SRC_URI[bash32-24.md5sum] = "5a2b976e761ab83f0fc7daae11451b86"
SRC_URI[bash32-24.sha256sum] = "d13c59fa6b182f79bbf9ba35f72085aeb755f9785985eaf9f4a55d58045fe327"
SRC_URI[bash32-25.md5sum] = "08668dc2825f65eced9cac6b09ce1b45"
SRC_URI[bash32-25.sha256sum] = "abfc1e1db3af956d4e71deb6a1ea9de1164c49fca4020b2546df3aa56f08cebe"
SRC_URI[bash32-26.md5sum] = "f35b2b217f088ff009f956894550d41d"
SRC_URI[bash32-26.sha256sum] = "07985caacd6c150cf89c51965bd18db2c89a9f32f7a2aa946757007409c292b9"
SRC_URI[bash32-27.md5sum] = "b5ff2b9610c61290f773c4b02cc1a37d"
SRC_URI[bash32-27.sha256sum] = "79647e3af94db8c2e636a293ee5b2f12516560b12aac0d4568a125d36cd21ddf"
SRC_URI[bash32-28.md5sum] = "016f5b56c93404d32aea09385f0fc13e"
SRC_URI[bash32-28.sha256sum] = "37289390175097c23efac5cb00d66b8b87e41fc37398064d11ac00de0e9934b0"
SRC_URI[bash32-29.md5sum] = "a81420626d4d88d0dce2ffac0ac56341"
SRC_URI[bash32-29.sha256sum] = "1f4e543171bd66bc28b197938811028ea70e9e406be2529326d2a586844b98e7"
SRC_URI[bash32-30.md5sum] = "11f91baf970c132949f9072ee93f2ea6"
SRC_URI[bash32-30.sha256sum] = "5ed6ca19787f2285e0c080056f65a137e053387380b3d8f6133812dd8f824afb"
SRC_URI[bash32-31.md5sum] = "f6bbc1e8ec0246740731c728ef476191"
SRC_URI[bash32-31.sha256sum] = "81ddc8f45e3272dd0e463fab87b58058be28d9c867674f3f53432dbd25cdfa48"
SRC_URI[bash32-32.md5sum] = "8180ec936770579bce69f0816c2dd878"
SRC_URI[bash32-32.sha256sum] = "926a9115e5c885ff9f2ef8abc6c3c552652afc370ebf65a87f41ec6810bdb569"
SRC_URI[bash32-33.md5sum] = "3cec33c3711860c4c6b7614afeec7870"
SRC_URI[bash32-33.sha256sum] = "9d7abee640dafbcdc6b75544015f3ffb5ed5aed2747465ec1412e959d3966740"
SRC_URI[bash32-34.md5sum] = "7bc6c5b5f38b7027152f8db0458a2e14"
SRC_URI[bash32-34.sha256sum] = "adc52e3427b606fe9649980b01c5b2b18f0509c4dd6d59a84f85b6a2989f9f8e"
SRC_URI[bash32-35.md5sum] = "a2db61fe90e39371d0e6cd2285ec9208"
SRC_URI[bash32-35.sha256sum] = "d3d906b23fce195d5d6f0db8969fa5264e80a98b5460008d6a05e4156ca73953"
SRC_URI[bash32-36.md5sum] = "95c70c7ae9de5bd3659c86284be7fb76"
SRC_URI[bash32-36.sha256sum] = "bdb24d65d1170234379fe587f5dc8b990c5e0c2d61c394bb8c81b91c1c64ce23"
SRC_URI[bash32-37.md5sum] = "62b876a3d7cd192cc8db2476fbb6b7b9"
SRC_URI[bash32-37.sha256sum] = "9688a352c0fb23d2ce6e685ce39cda1c49f4aa7819bde2508ff8c90003f484df"
SRC_URI[bash32-38.md5sum] = "aca3afc341bd3e5a0d8a3b4ca40dbb3f"
SRC_URI[bash32-38.sha256sum] = "0e3649531c3a5675743980ecf5ff5fcbca2801afe4dca7fb4b250aae7ac3b782"
SRC_URI[bash32-39.md5sum] = "e240c34f979b64bcb83c5f6567110bb1"
SRC_URI[bash32-39.sha256sum] = "46d427fd5b1509ec7dd980c07efd88634fde61cf07ab221dcbde9e1021bd2817"
