LICENSE = "GPL"
SECTION = "gpe"
inherit gpe

DESCRIPTION = "GPE modal help"
DEPENDS = "virtual/x11"
MAINTAINER = "Phil Blundell <pb@handhelds.org>"

do_compile_prepend() {
	rm *.d
}
