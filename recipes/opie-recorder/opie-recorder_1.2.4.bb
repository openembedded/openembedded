require ${PN}.inc

PR = "r1"

SRC_URI = "http://sources.openembedded.org/opie-1.2.4-split_noncore_multimedia_opierec.tar.bz2;name=split_noncore_multimedia_opierec \
           http://sources.openembedded.org/opie-1.2.4-split_pics.tar.bz2;name=split_pics \
           http://sources.openembedded.org/opie-1.2.4-split_apps.tar.bz2;name=split_apps"
SRC_URI[split_noncore_multimedia_opierec.md5sum] = "c06c95b3295de47cae984946e52b3c0f"
SRC_URI[split_noncore_multimedia_opierec.sha256sum] = "76f1c3b31640de6e81447a216ffaa0a19f7fe3181123faab289077462c6894b8"
SRC_URI[split_pics.md5sum] = "5499dc84b65395ab99bda6ed9d01ff0f"
SRC_URI[split_pics.sha256sum] = "f22781f36e84e12d51fff1eb68cc3fb98221c7d807a82226813b7e974a604109"
SRC_URI[split_apps.md5sum] = "67a43e8e4bcd9e63b884ea25deea5b34"
SRC_URI[split_apps.sha256sum] = "a33a55efb4ae4c15a8c2c5d6faba6d671a5652da8e216ce35088896fe597215b"
