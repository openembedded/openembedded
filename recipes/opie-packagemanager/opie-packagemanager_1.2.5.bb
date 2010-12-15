require ${PN}.inc

PR = "r0"

DEPENDS = "opkg"

EXTRA_QMAKEVARS_PRE += "LIBIPK_INC_DIR=${STAGING_INCDIR}/libopkg"

export CONFIG_LIBOPK_DEP=y

SRC_URI = "http://sources.openembedded.org/opie-1.2.5-split_noncore_settings_${APPNAME}.tar.bz2;name=split_noncore_settings_appname \
           http://sources.openembedded.org/opie-1.2.5-split_pics.tar.bz2;name=split_pics \
           http://sources.openembedded.org/opie-1.2.5-split_apps.tar.bz2;name=split_apps"
SRC_URI[split_noncore_settings_appname.md5sum] = "67182630eddbcf4411aa06ab41b2a2a6"
SRC_URI[split_noncore_settings_appname.sha256sum] = "02dd61fd5911d0d7db6b8790457812818a8ad702aa0021345232f80f766d1645"
SRC_URI[split_pics.md5sum] = "e9b68749d67295f7080a23e39b17335e"
SRC_URI[split_pics.sha256sum] = "0a7aab6d0bce04d6a9c257d768d8a1a481d38ba527d6e6e50723973789954b4a"
SRC_URI[split_apps.md5sum] = "c765d13427e4dc8ee396e4dfed2dbe73"
SRC_URI[split_apps.sha256sum] = "0fea454d8d286f7febc7449e4a06f73e941e8b22e9bab904a32e57f35479862a"
