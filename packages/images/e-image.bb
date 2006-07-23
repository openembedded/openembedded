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
                        e17-gpe-menu-convert \
                        pango-module-basic-fc \
                        gdk-pixbuf-loader-bmp \
                        gdk-pixbuf-loader-gif \
                        gdk-pixbuf-loader-jpeg \
                        gdk-pixbuf-loader-png \
                        gdk-pixbuf-loader-pnm \
                        gdk-pixbuf-loader-xbm \
                        gdk-pixbuf-loader-xpm"
#                        gdk-pixbuf-loader-pcx \
#                        gdk-pixbuf-loader-ico \
#                        gdk-pixbuf-loader-ani \
#                        gdk-pixbuf-loader-ras \
#                        gdk-pixbuf-loader-tga \
#                        gdk-pixbuf-loader-wbmp \

DEPENDS += "task-e-x11-core task-gpe e17-gpe-menu-convert figment xhost gpe-soundserver gpe-confd xauth"

RDEPENDS = "${IPKG_INSTALL}"
