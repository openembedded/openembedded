require ${PN}.inc

PR = "r4"

SRC_URI = "http://sources.openembedded.org/opie-1.2.4-split_core_applets_irdaapplet.tar.bz2;name=split_core_applets_irdaapplet \
           http://sources.openembedded.org/opie-1.2.4-split_pics.tar.bz2;name=split_pics \
           http://sources.openembedded.org/opie-1.2.4-split_sounds.tar.bz2;name=split_sounds \
           http://sources.openembedded.org/opie-1.2.4-split_apps.tar.bz2;name=split_apps \
	  "
SRC_URI[split_core_applets_irdaapplet.md5sum] = "eaf45b239f13e3e3fa405b8f2eb8c6cf"
SRC_URI[split_core_applets_irdaapplet.sha256sum] = "2c9247403f4257ccf38e16c6ea0d4866e72723afc723658eb06a49e00b2bd7d4"
SRC_URI[split_pics.md5sum] = "5499dc84b65395ab99bda6ed9d01ff0f"
SRC_URI[split_pics.sha256sum] = "f22781f36e84e12d51fff1eb68cc3fb98221c7d807a82226813b7e974a604109"
SRC_URI[split_sounds.md5sum] = "eab6336ddc7a8b4db9fca94cef2485b1"
SRC_URI[split_sounds.sha256sum] = "a110602cd5013c6a406765f351a8484478617b2002377dd3c02a8bf450ca845f"
SRC_URI[split_apps.md5sum] = "67a43e8e4bcd9e63b884ea25deea5b34"
SRC_URI[split_apps.sha256sum] = "a33a55efb4ae4c15a8c2c5d6faba6d671a5652da8e216ce35088896fe597215b"
