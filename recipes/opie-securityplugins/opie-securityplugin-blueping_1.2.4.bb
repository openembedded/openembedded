require opie-securityplugin-blueping.inc

PR = "r1"

SRC_URI = "http://sources.openembedded.org/opie-1.2.4-split_noncore_securityplugins_blueping.tar.bz2;name=split_noncore_securityplugins_blueping \
           http://sources.openembedded.org/opie-1.2.4-split_pics.tar.bz2;name=split_pics"
SRC_URI[split_noncore_securityplugins_blueping.md5sum] = "f5898a47c684b236d54cd826cfa57184"
SRC_URI[split_noncore_securityplugins_blueping.sha256sum] = "9bc6d8b6f28c73c0d07d7a437878a8d38381a14a4f2ce6cf55027894209b2ac7"
SRC_URI[split_pics.md5sum] = "5499dc84b65395ab99bda6ed9d01ff0f"
SRC_URI[split_pics.sha256sum] = "f22781f36e84e12d51fff1eb68cc3fb98221c7d807a82226813b7e974a604109"

