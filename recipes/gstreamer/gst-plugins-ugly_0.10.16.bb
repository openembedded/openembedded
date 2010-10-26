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

