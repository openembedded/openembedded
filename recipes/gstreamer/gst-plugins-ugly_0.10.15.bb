require gst-plugins.inc

PR = "${INC_PR}.0"

DEPENDS += "gst-plugins-base mpeg2dec libsidplay"

SRC_URI += "\
  file://gstmad_16bit.patch \
  file://gstsid_autofoo_HACK.patch \
"
SRC_URI[archive.md5sum] = "21c034a762a5da252f91640e53bfe457"
SRC_URI[archive.sha256sum] = "ceebb7878d957a61cf437c1f93934a0371631fa50e4111ef016691d65866790c"

python() {
	# Don't build, if we are building an ENTERPRISE distro
	enterprise = bb.data.getVar("ENTERPRISE_DISTRO", d, 1)
	if enterprise == "1":
		raise bb.parse.SkipPackage("gst-plugins-ugly will only build if ENTERPRISE_DISTRO != 1")
}

