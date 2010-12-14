require ${PN}.inc

PR = "r1"

SRC_URI = "http://sources.openembedded.org/opie-1.2.4-split_inputmethods_multikey.tar.bz2;name=split_inputmethods_multikey \
           http://sources.openembedded.org/opie-1.2.4-split_share.tar.bz2;name=split_share \
           file://fix-rpath.patch"
SRC_URI[split_inputmethods_multikey.md5sum] = "37ba8820ba923b2d2d1fed13a0618a9a"
SRC_URI[split_inputmethods_multikey.sha256sum] = "050d687c643e85b8482ac8cb7e76a011f69cff4846e43111a7c93eeaed8858a7"
SRC_URI[split_share.md5sum] = "d2c49981de19317e14f23b68672d118d"
SRC_URI[split_share.sha256sum] = "f2c6930ff0aea7045fc4e37a1e1d8a54a2c9205c60e2f15f64ab31011b7893fc"

#           file://friendly-button-names.patch"
