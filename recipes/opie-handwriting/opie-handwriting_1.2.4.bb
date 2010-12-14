require ${PN}.inc

PR = "r1"

SRC_URI = "http://sources.openembedded.org/opie-1.2.4-split_inputmethods_handwriting.tar.bz2;name=split_inputmethods_handwriting \
	http://sources.openembedded.org/opie-1.2.4-split_etc_qimpen.tar.bz2;name=split_etc_qimpen"
SRC_URI[split_inputmethods_handwriting.md5sum] = "e38f191049ffc13f6c8486e9f31fdd3d"
SRC_URI[split_inputmethods_handwriting.sha256sum] = "e3391096e0025ff7d6a78d99b685a815796dea0569f059abe28efb550306bd00"
SRC_URI[split_etc_qimpen.md5sum] = "39715eb4556066d09e05aac4a5f3dc60"
SRC_URI[split_etc_qimpen.sha256sum] = "291f6f8b466c4da5ec451f9c186e466b4cbced99ac43b0d9790a7a7829a887fd"
