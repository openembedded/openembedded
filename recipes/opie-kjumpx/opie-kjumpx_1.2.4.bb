require ${PN}.inc

PR = "r1"

SRC_URI = "http://sources.openembedded.org/opie-1.2.4-split_inputmethods_kjumpx.tar.bz2;name=split_inputmethods_kjumpx \
	   http://sources.openembedded.org/opie-1.2.4-split_pics.tar.bz2;name=split_pics"
SRC_URI[split_inputmethods_kjumpx.md5sum] = "02849d22bdf4d493885cd9b8c13131fb"
SRC_URI[split_inputmethods_kjumpx.sha256sum] = "520db273a1455f671b5fea790ecc6b39f067b2195baa1dca26807325f5be90de"
SRC_URI[split_pics.md5sum] = "5499dc84b65395ab99bda6ed9d01ff0f"
SRC_URI[split_pics.sha256sum] = "f22781f36e84e12d51fff1eb68cc3fb98221c7d807a82226813b7e974a604109"
