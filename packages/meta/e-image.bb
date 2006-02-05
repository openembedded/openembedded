DESCRIPTION = "An X11-based distribution with the Enlightenment Window Manager and Tools"
PR = "r4"

include e-image-core.bb

export IMAGE_BASENAME = "e-image"
export IPKG_INSTALL += "task-e-x11-core \
                        gpe-task-pim \
                        gpe-task-settings \
                        gpe-task-apps \
                        gpe-task-connectivity \
                        gpe-task-games \
                        gpe-task-apps-extra \
                        figment \
                        xhost \
                        gpe-soundserver \
                        gpe-confd \
                        xauth"

DEPENDS += "task-e-x11-core task-gpe"

RDEPENDS = "${IPKG_INSTALL}"
