require ${PN}.inc

PR = "r2"

SRC_URI = "http://sources.openembedded.org/opie-1.2.4-split_noncore_settings_networksettings.tar.bz2;name=split_noncore_settings_networksettings \
           http://sources.openembedded.org/opie-1.2.4-split_pics.tar.bz2;name=split_pics \
           http://sources.openembedded.org/opie-1.2.4-split_apps.tar.bz2;name=split_apps \
           http://sources.openembedded.org/opie-1.2.4-split_root.tar.bz2;name=split_root \
	   file://wireless.patch \
          "
SRC_URI[split_noncore_settings_networksettings.md5sum] = "240ffed86dc29b63c6a4b4090a96b31e"
SRC_URI[split_noncore_settings_networksettings.sha256sum] = "27382792be130390e4ce26b1d6747d19c08db5b1c694deaa41879df50151143c"
SRC_URI[split_pics.md5sum] = "5499dc84b65395ab99bda6ed9d01ff0f"
SRC_URI[split_pics.sha256sum] = "f22781f36e84e12d51fff1eb68cc3fb98221c7d807a82226813b7e974a604109"
SRC_URI[split_apps.md5sum] = "67a43e8e4bcd9e63b884ea25deea5b34"
SRC_URI[split_apps.sha256sum] = "a33a55efb4ae4c15a8c2c5d6faba6d671a5652da8e216ce35088896fe597215b"
SRC_URI[split_root.md5sum] = "5d2f707b17e00cad32e8eacc1641cf10"
SRC_URI[split_root.sha256sum] = "7b543d57f908b76a53270fd4b0df0a60a0863eca32adb2eb5815a3f1a279d9d6"
