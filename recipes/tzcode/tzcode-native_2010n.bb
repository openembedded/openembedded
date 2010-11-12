require tzcode-native.inc

# Note that elsie.nci.nih.gov removes old versions when new is coming out
# So if this doesn't build for you because of missing source file, just
# bump it to the latest available version, removing old one
# Also, tzdata (and it is needed to build tzcode) version can differ from
# tzcode version, thus this variable

TZDATA_PV = "2010o"

SRC_URI[tzcode-2010n.md5sum] = "a7a776a5713831993e814fe0c05f9fd5"
SRC_URI[tzcode-2010n.sha256sum] = "f2810d87764f142c762b6d5ec3cb9621c981503c041246a1f6f3c24fd5ef131a"
SRC_URI[tzdata-2010o.md5sum] = "5cae5c56fad81dc29f8fcd933a05768e"
SRC_URI[tzdata-2010o.sha256sum] = "cd0f3799688b3b870cd988505e47c2975b1808e73ec0677bc9db4b705b534c07"

PR = "${INC_PR}.0"
