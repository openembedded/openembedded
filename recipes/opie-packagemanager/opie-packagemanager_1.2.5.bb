require ${PN}.inc

PR = "r0"

DEPENDS = "opkg"

EXTRA_QMAKEVARS_PRE += "LIBIPK_INC_DIR=${STAGING_INCDIR}/libopkg"

export CONFIG_LIBOPK_DEP=y

SRC_URI = "http://sources.openembedded.org/opie-1.2.5-split_noncore_settings_${APPNAME}.tar.bz2 \
           http://sources.openembedded.org/opie-1.2.5-split_pics.tar.bz2 \
           http://sources.openembedded.org/opie-1.2.5-split_apps.tar.bz2"
