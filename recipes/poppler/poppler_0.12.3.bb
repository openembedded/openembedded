require poppler.inc

DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_angstrom = "1"

EXTRA_OECONF_append = " --disable-abiword-output "

RDEPENDS = "poppler-data"
