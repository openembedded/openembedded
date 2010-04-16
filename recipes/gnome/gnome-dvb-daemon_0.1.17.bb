DESCRIPTION = "GNOME DVB Daemon is a daemon written in Vala based on GStreamer to setup your DVB devices, record and watch TV shows and browse EPG. It can be controlled by any application via its D-Bus interface."
LICENSE = "GPLv3"

DEPENDS = "libxml2 python-dbus python-gst python-pygtk libgee vala-native gstreamer gst-plugins-good gst-plugins-bad glib-2.0 dbus-glib sqlite3 gst-rtsp"
RDEPENDS = "python-dbus python-gst python-pygtk gst-plugin-dvb gst-fluendo-mpegdemux dvb-apps dvb-scan dvb-tzap dvb-czap dvbstream"

inherit gnome

SRC_URI[archive.md5sum] = "57a583709fdce994038c4562ba5733b7"
SRC_URI[archive.sha256sum] = "93838655e7c062137966733dee0db9ae204477cf44984b54d2488be6ce2ba127"

SRC_URI = "http://launchpad.net/gnome-dvb-daemon/trunk/${PV}/+download/gnome-dvb-daemon-${PV}.tar.bz2;name=archive"

# We have no use for checking using gst-inspect when crosscompiling, so sed out the check
do_configure_prepend() {
	sed -i -e /AG_GST_CHECK_GST_INSPECT/d \
	       -e /G_GST_CHECK_MODULE/d \
	       -e /AM_CHECK_PYMOD/d \
	       ${S}/configure.ac
	sed -i -e 's:PYTHON_INCLUDES="-I${py_prefix}/include/python${PYTHON_VERSION}":PYTHON_INCLUDES="-I${STAGING_INCDIR}/python$PYTHON_VERSION":g' \
	       -e 's:PYTHON_INCLUDES="$PYTHON_INCLUDES -I${py_exec_prefix}/include/python${PYTHON_VERSION}":PYTHON_INCLUDES="-I${STAGING_INCDIR}/python$PYTHON_VERSION":g' \
	       ${S}/m4/python.m4
}

# TODO: split out UI and python stuff
FILES_${PN} += "${datadir}/dbus-1 ${libdir}/python*"
FILES_${PN}-dbg += "${libdir}/python*/*/*/*/.debug"


