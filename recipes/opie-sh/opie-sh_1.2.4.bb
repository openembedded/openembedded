require ${PN}.inc

PR = "r2"

SRC_URI = "http://sources.openembedded.org/opie-1.2.4-split_noncore_tools_opie-sh.tar.bz2;name=split_noncore_tools_opie-sh \
           http://sources.openembedded.org/opie-1.2.4-split_pics.tar.bz2;name=split_pics \
           http://sources.openembedded.org/opie-1.2.4-split_help.tar.bz2;name=split_help \
           http://sources.openembedded.org/opie-1.2.4-split_share.tar.bz2;name=split_share \
           http://sources.openembedded.org/opie-1.2.4-split_apps.tar.bz2;name=split_apps \
           http://sources.openembedded.org/opie-1.2.4-split_bin.tar.bz2;name=split_bin \
           file://opie-sh-path.patch \
           file://opie-sh-fsmounter-name.patch;patchdir=${WORKDIR}/apps"
SRC_URI[split_noncore_tools_opie-sh.md5sum] = "bc57f7ab07181c122ebc382e302bb594"
SRC_URI[split_noncore_tools_opie-sh.sha256sum] = "a1305994918160449177b24efe384a0de87dc9dfcecf476e33b87cf8999b5bb1"
SRC_URI[split_pics.md5sum] = "5499dc84b65395ab99bda6ed9d01ff0f"
SRC_URI[split_pics.sha256sum] = "f22781f36e84e12d51fff1eb68cc3fb98221c7d807a82226813b7e974a604109"
SRC_URI[split_help.md5sum] = "ce138d39070637cefe6e746e3a32c8c4"
SRC_URI[split_help.sha256sum] = "107c9e70503bed901593cc34a270245f02104142dd940c5835a656521922394a"
SRC_URI[split_share.md5sum] = "d2c49981de19317e14f23b68672d118d"
SRC_URI[split_share.sha256sum] = "f2c6930ff0aea7045fc4e37a1e1d8a54a2c9205c60e2f15f64ab31011b7893fc"
SRC_URI[split_apps.md5sum] = "67a43e8e4bcd9e63b884ea25deea5b34"
SRC_URI[split_apps.sha256sum] = "a33a55efb4ae4c15a8c2c5d6faba6d671a5652da8e216ce35088896fe597215b"
SRC_URI[split_bin.md5sum] = "d63089ebb9a87636e30fecefcc5b2cb8"
SRC_URI[split_bin.sha256sum] = "8caf1981a2463029c1a27d965af8573d46b8e2ab818fb61b8e73ff40e43aab0c"
