require tzdata.inc

# Note that elsie.nci.nih.gov removes old archives when new is being
# released. So if this doesn't build for you because of missing source file
# just bump it to the latest available version, removing old one

PR = "${INC_PR}.0"

SRC_URI[tar.md5sum] = "5cae5c56fad81dc29f8fcd933a05768e"
SRC_URI[tar.sha256sum] = "cd0f3799688b3b870cd988505e47c2975b1808e73ec0677bc9db4b705b534c07"
