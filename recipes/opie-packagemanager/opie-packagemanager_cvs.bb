require ${PN}.inc

PV = "${OPIE_GIT_PV}"
PR = "r2"

DEPENDS = "opkg"

EXTRA_QMAKEVARS_PRE += "LIBIPK_INC_DIR=${STAGING_INCDIR}/libopkg"

export CONFIG_LIBOPK_DEP=y

SRC_URI = "${OPIE_GIT};protocol=git;subpath=noncore/settings/${APPNAME} \
           ${OPIE_GIT};protocol=git;subpath=pics \
           ${OPIE_GIT};protocol=git;subpath=apps"
