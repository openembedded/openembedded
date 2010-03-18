require xorg-driver-video.inc

DESCRIPTION = "X.Org X server -- openchrome display driver"
PE = "1"

do_configure_prepend() {
	rm ${S}/acinclude.m4 || true
}

SRC_URI[archive.md5sum] = "c0820787e89958c9114d359b6a3cd464"
SRC_URI[archive.sha256sum] = "b7e4858d6b5c6428fae2485a2c2097cdf6073268ef812aae2ccbc3d936db7410"
