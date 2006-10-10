LICENSE = "GPL"
SECTION = "gpe"
inherit gpe

DESCRIPTION = "GPE modal help"
DEPENDS = "virtual/libx11"

do_compile_prepend() {
	rm *.d
}
