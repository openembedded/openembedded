# This wrapper builds a native version of the Oracal
# Berkeley DB for those packages which need it (e.g.
# perl).

VIRTUAL_NAME = "virtual/db-native"
CONFLICTS = "db3-native"
#PR tracks the non-native package

inherit native

do_package() {
:
}

PACKAGES = ""
