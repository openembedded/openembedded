require ${PN}.inc

PR = "r1"

TAG = "${@'v' + bb.data.getVar('PV',d,1).replace('.', '_')}"

SRC_URI = "http://sources.openembedded.org/opie-1.2.4-split_i18n.tar.bz2;name=split_i18n \
	   http://sources.openembedded.org/opie-1.2.4-split_etc_dict.tar.bz2;name=split_etc_dict"
SRC_URI[split_i18n.md5sum] = "1cd7d67a1a90f99d701d77e0e27f594a"
SRC_URI[split_i18n.sha256sum] = "21e630a71d272fa779c84a4c04070e53ef9ae4d7a43de3352e3e9a020093ab8c"
SRC_URI[split_etc_dict.md5sum] = "46392147c24cd999b73c60d8ea5a85bb"
SRC_URI[split_etc_dict.sha256sum] = "765cac24abcb35e3f2682ec9c117517ea35604002ada0bf018009318b8c451aa"
