DESCRIPTION = "GNOME Mobile & Embedded Initiative"
PR = "r2"

inherit task

PACKAGES = 'gmae-core \
            gmae-toolkit \
            gmae-user \
	    task-gmae \
	    '

RDEPENDS_gmae-core = " \
            ${XSERVER} \
	    glib-2.0 \
	    gtk+ \
            "

RDEPENDS_gmae-toolkit = " \
            pango \
	    cairo \
	    atk \
            "

RDEPENDS_gmae-user = " \
            bluez-utils \
	    eds-dbus \
	    telepathy-gabble libtelepathy \
	    avahi-utils \
	    gstreamer \
	    matchbox-wm matchbox-panel \
	    gconf \
	    gnome-vfs \
	    "

RDEPENDS_task-gmae = " \
            gmae-core \
            gmae-toolkit \
            gmae-user \
	    "

