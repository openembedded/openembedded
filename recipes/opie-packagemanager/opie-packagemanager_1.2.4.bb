require ${PN}.inc

PR = "r2"

DEPENDS = "opkg"

EXTRA_QMAKEVARS_PRE += "LIBIPK_INC_DIR=${STAGING_INCDIR}/libopkg"

SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/noncore/settings/${APPNAME};cvsdate=${SRCDATE} \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/pics;cvsdate=${SRCDATE} \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/apps \
           file://split-config.patch;patch=1 \
           file://opkg.patch;patch=1 \
           file://opkg_update.patch;patch=1"
