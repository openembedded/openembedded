require gst-plugins.inc

PR = "${INC_PR}.0"

DEPENDS += "gst-plugins-base mpeg2dec libsidplay"

SRC_URI += "\
  file://gstmad_16bit.patch;patch=1 \
  file://gstsid_autofoo_HACK.patch;patch=1 \
"

SRC_URI[archive.md5sum] = "0bc0d27bcce88c73ef6c81e88624e686"
SRC_URI[archive.sha256sum] = "78dba9963e130cfd09f294b60219e6562459c5d848bc3b38a653db7f21fc850b"

python() {
	# Don't build, if we are building an ENTERPRISE distro
	enterprise = bb.data.getVar("ENTERPRISE_DISTRO", d, 1)
	if enterprise == "1":
		raise bb.parse.SkipPackage("gst-plugins-ugly will only build if ENTERPRISE_DISTRO != 1")
}

