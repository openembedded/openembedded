require e-image-core.bb
DESCRIPTION = "An X11-based distribution with the Enlightenment Window Manager and Tools"

DEPENDS += "task-e-x11-core task-gpe-base task-gpe-pim task-gpe-settings task-gpe-apps task-gpe-connectivity task-gpe-games \
            figment xhost gpe-soundserver gpe-confd xauth"

IMAGE_INSTALL += "task-e-x11-core \
                        ask-gpe-pim \
                        task-gpe-settings \
                        task-gpe-apps \
                        task-gpe-connectivity \
                        task-gpe-games \
                        task-apps-extra \
                        figment \
                        xhost \
                        gpe-soundserver \
                        gpe-confd \
                        xauth \
                        pango-module-basic-fc \
                        gdk-pixbuf-loader-bmp \
                        gdk-pixbuf-loader-gif \
                        gdk-pixbuf-loader-jpeg \
                        gdk-pixbuf-loader-png \
                        gdk-pixbuf-loader-pnm \
                        gdk-pixbuf-loader-xbm \
                        gdk-pixbuf-loader-xpm"
