require gst-plugins-ugly_${PV}.bb
DEPENDS += "libsidplay"
PROVIDES = "gst-plugin-sid"

SRC_URI = "\
  http://gstreamer.freedesktop.org/src/gst-plugins-ugly/gst-plugins-ugly-${PV}.tar.bz2 \
  file://gstsid_autofoo_HACK.patch;patch=1 \
"
S = "${WORKDIR}/gst-plugins-ugly-${PV}"

python() {
	# Don't build, if we are building an ENTERPRISE distro
	enterprise = bb.data.getVar("ENTERPRISE_DISTRO", d, 1)
	if enterprise == "0":
		raise bb.parse.SkipPackage("gst-plugins-ugly-sid will only build if ENTERPRISE_DISTRO != 0")
}

