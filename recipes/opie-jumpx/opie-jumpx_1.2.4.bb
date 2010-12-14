require ${PN}.inc

PR = "r1"

SRC_URI = "http://sources.openembedded.org/opie-1.2.4-split_inputmethods_jumpx.tar.bz2;name=split_inputmethods_jumpx \
	   http://sources.openembedded.org/opie-1.2.4-split_pics.tar.bz2;name=split_pics"
SRC_URI[split_inputmethods_jumpx.md5sum] = "b2ac2b20e427763e41a996b40607d5ef"
SRC_URI[split_inputmethods_jumpx.sha256sum] = "6f6956b9fa6aa920354469e62ecd3bf7ea07571455038b36c7ede9c129019fda"
SRC_URI[split_pics.md5sum] = "5499dc84b65395ab99bda6ed9d01ff0f"
SRC_URI[split_pics.sha256sum] = "f22781f36e84e12d51fff1eb68cc3fb98221c7d807a82226813b7e974a604109"
