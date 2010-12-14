require ${PN}.inc

PR = "r1"

SRC_URI = "http://sources.openembedded.org/opie-1.2.4-split_core_multimedia_opieplayer.tar.bz2;name=split_core_multimedia_opieplayer \
           http://sources.openembedded.org/opie-1.2.4-split_pics.tar.bz2;name=split_pics \
           http://sources.openembedded.org/opie-1.2.4-split_apps.tar.bz2;name=split_apps \
           file://double_name.patch"
SRC_URI[split_core_multimedia_opieplayer.md5sum] = "64271b17f8dd9f968e82d4f66d810c53"
SRC_URI[split_core_multimedia_opieplayer.sha256sum] = "47b43dd5883780d04f825dda7dfa1a53355deb548e59a49c01a330e9d88360aa"
SRC_URI[split_pics.md5sum] = "5499dc84b65395ab99bda6ed9d01ff0f"
SRC_URI[split_pics.sha256sum] = "f22781f36e84e12d51fff1eb68cc3fb98221c7d807a82226813b7e974a604109"
SRC_URI[split_apps.md5sum] = "67a43e8e4bcd9e63b884ea25deea5b34"
SRC_URI[split_apps.sha256sum] = "a33a55efb4ae4c15a8c2c5d6faba6d671a5652da8e216ce35088896fe597215b"
