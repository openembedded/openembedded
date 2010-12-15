require ${PN}.inc

PR = "r0"

SRC_URI = "http://sources.openembedded.org/opie-1.2.5-split_inputmethods_handwriting.tar.bz2;name=split_inputmethods_handwriting \
	http://sources.openembedded.org/opie-1.2.5-split_etc_qimpen.tar.bz2;name=split_etc_qimpen"
SRC_URI[split_inputmethods_handwriting.md5sum] = "2ba77c63a71bc0f4a3bddbcc15a1b816"
SRC_URI[split_inputmethods_handwriting.sha256sum] = "9d7e305fd8ccce226a7dde687024641657add23bb7b46d898b6ec7066b6e41f0"
SRC_URI[split_etc_qimpen.md5sum] = "4a95b508202bafcdb204abcbd0dd17d3"
SRC_URI[split_etc_qimpen.sha256sum] = "a9e64ba22c71ef2c3c76a52529f95a01fe172d5f5835906da2ad10da0cd60539"
