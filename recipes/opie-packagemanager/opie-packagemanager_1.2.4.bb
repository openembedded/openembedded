require ${PN}.inc

PR = "r4"

DEPENDS = "opkg"

EXTRA_QMAKEVARS_PRE += "LIBIPK_INC_DIR=${STAGING_INCDIR}/libopkg"

SRC_URI = "http://sources.openembedded.org/opie-1.2.4-split_noncore_settings_${APPNAME}.tar.bz2;name=split_noncore_settings_appname \
           http://sources.openembedded.org/opie-1.2.4-split_pics.tar.bz2;name=split_pics \
           http://sources.openembedded.org/opie-1.2.4-split_apps.tar.bz2;name=split_apps \
           file://split-config.patch \
           file://opkg.patch \
           file://opkg_update.patch"
SRC_URI[split_noncore_settings_appname.md5sum] = "1bcd7dee5e444cacf51bd60ead83be91"
SRC_URI[split_noncore_settings_appname.sha256sum] = "7ee28ca39a37faa12f2b5cc2a18f62076333aefa91f62a0ee977cfe65d4c95c1"
SRC_URI[split_pics.md5sum] = "5499dc84b65395ab99bda6ed9d01ff0f"
SRC_URI[split_pics.sha256sum] = "f22781f36e84e12d51fff1eb68cc3fb98221c7d807a82226813b7e974a604109"
SRC_URI[split_apps.md5sum] = "67a43e8e4bcd9e63b884ea25deea5b34"
SRC_URI[split_apps.sha256sum] = "a33a55efb4ae4c15a8c2c5d6faba6d671a5652da8e216ce35088896fe597215b"
