require emacs_cvs.bb

# full X (non-diet) is needed for X support
DEPENDS += "libx11"

EXTRA_OECONF = "--without-sound"

RREPLACES = "emacs"
