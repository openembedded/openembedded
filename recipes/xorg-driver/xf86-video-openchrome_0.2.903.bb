require xorg-driver-video.inc

DESCRIPTION = "X.Org X server -- openchrome display driver"
PE = "1"

do_configure_prepend() {
	rm ${S}/acinclude.m4 || true
}

