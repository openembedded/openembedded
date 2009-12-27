require ${PN}.inc

PV = "${OPIE_GIT_PV}"
PR = "r4"

SRC_URI = "${OPIE_GIT};protocol=git;subpath=noncore/settings/networksettings \
           ${OPIE_GIT};protocol=git;subpath=pics \
           ${OPIE_GIT};protocol=git;subpath=apps \
           ${HANDHELDS_CVS};module=opie/root \
          "
