require gst-plugins.inc

PR = "${INC_PR}.1"

DEPENDS += "gst-plugins-base mpeg2dec libsidplay"

SRC_URI += "\
  file://gstmad_16bit.patch \
  file://gstsid_autofoo_HACK.patch \
"
SRC_URI[archive.md5sum] = "989e1b0fab010f73f76912f70ec5f62a"
SRC_URI[archive.sha256sum] = "d7fc7636001e78736540c628ad889888cb85ea722f08d1c6813b16682dd9c09c"

python() {
	# Don't build, if we are building an ENTERPRISE distro
	enterprise = bb.data.getVar("ENTERPRISE_DISTRO", d, 1)
	if enterprise == "1":
		raise bb.parse.SkipPackage("gst-plugins-ugly will only build if ENTERPRISE_DISTRO != 1")
}

PACKAGES_DYNAMIC = "\
gst-plugin-a52dec* \
gst-plugin-asf* \
gst-plugin-cdio* \
gst-plugin-dvdlpcmdec* \
gst-plugin-dvdread* \
gst-plugin-dvdsub* \
gst-plugin-iec958* \
gst-plugin-lame* \
gst-plugin-mad* \
gst-plugin-mpeg2dec* \
gst-plugin-mpegaudioparse* \
gst-plugin-mpegstream* \
gst-plugin-rmdemux* \
gst-plugin-sid* \
gst-plugin-x264* \
"
