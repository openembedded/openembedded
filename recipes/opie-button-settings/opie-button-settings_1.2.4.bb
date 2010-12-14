require ${PN}.inc

PR = "r1"

SRC_URI = "http://sources.openembedded.org/opie-1.2.4-split_core_settings_button.tar.bz2;name=split_core_settings_button \
           http://sources.openembedded.org/opie-1.2.4-split_pics.tar.bz2;name=split_pics \
           http://sources.openembedded.org/opie-1.2.4-split_apps.tar.bz2;name=split_apps"
SRC_URI[split_core_settings_button.md5sum] = "30e17a262a9f51d8fc3b04e957dc7c06"
SRC_URI[split_core_settings_button.sha256sum] = "bf57e64dec68af81ff47fe5154e1870155403df5f9bc02d7257b19b9ba4f3c7d"
SRC_URI[split_pics.md5sum] = "5499dc84b65395ab99bda6ed9d01ff0f"
SRC_URI[split_pics.sha256sum] = "f22781f36e84e12d51fff1eb68cc3fb98221c7d807a82226813b7e974a604109"
SRC_URI[split_apps.md5sum] = "67a43e8e4bcd9e63b884ea25deea5b34"
SRC_URI[split_apps.sha256sum] = "a33a55efb4ae4c15a8c2c5d6faba6d671a5652da8e216ce35088896fe597215b"
