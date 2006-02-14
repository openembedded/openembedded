include e-image-core.bb
DESCRIPTION = "An X11-based distribution with the Enlightenment Window Manager and Tools"
PR = "r5"

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
                        xauth \
                        e17-gpe-menu-convert"

DEPENDS += "task-e-x11-core task-gpe e17-gpe-menu-convert"

RDEPENDS = "${IPKG_INSTALL}"
