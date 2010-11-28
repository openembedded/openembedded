require ${PN}.inc

PR = "r4"

DEPENDS = "opkg"

EXTRA_QMAKEVARS_PRE += "LIBIPK_INC_DIR=${STAGING_INCDIR}/libopkg"

SRC_URI = "http://sources.openembedded.org/opie-1.2.4-split_noncore_settings_${APPNAME}.tar.bz2 \
           http://sources.openembedded.org/opie-1.2.4-split_pics.tar.bz2 \
           http://sources.openembedded.org/opie-1.2.4-split_apps.tar.bz2 \
           file://split-config.patch \
           file://opkg.patch \
           file://opkg_update.patch"
