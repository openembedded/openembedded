require ${PN}.inc

PR = "r1"

SRC_URI = "http://sources.openembedded.org/opie-1.2.4-split_noncore_multimedia_powerchord.tar.bz2;name=split_noncore_multimedia_powerchord \
           http://sources.openembedded.org/opie-1.2.4-split_pics.tar.bz2;name=split_pics \
           http://sources.openembedded.org/opie-1.2.4-split_share.tar.bz2;name=split_share \
           http://sources.openembedded.org/opie-1.2.4-split_apps.tar.bz2;name=split_apps"
SRC_URI[split_noncore_multimedia_powerchord.md5sum] = "271a67c1e2b5e24f5a64e8d2c729da4e"
SRC_URI[split_noncore_multimedia_powerchord.sha256sum] = "29f2eee8ad210b09c307efd47fa16df7ea7a6116db730d38e56df0f904162143"
SRC_URI[split_pics.md5sum] = "5499dc84b65395ab99bda6ed9d01ff0f"
SRC_URI[split_pics.sha256sum] = "f22781f36e84e12d51fff1eb68cc3fb98221c7d807a82226813b7e974a604109"
SRC_URI[split_share.md5sum] = "d2c49981de19317e14f23b68672d118d"
SRC_URI[split_share.sha256sum] = "f2c6930ff0aea7045fc4e37a1e1d8a54a2c9205c60e2f15f64ab31011b7893fc"
SRC_URI[split_apps.md5sum] = "67a43e8e4bcd9e63b884ea25deea5b34"
SRC_URI[split_apps.sha256sum] = "a33a55efb4ae4c15a8c2c5d6faba6d671a5652da8e216ce35088896fe597215b"
