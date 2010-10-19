DESCRIPTION = "Meta-package for Openmoko Misc. Feed Items"
LICENSE = "MIT"

RDEPENDS_${PN} = "\
  task-openmoko-debug \
  task-openmoko-native-sdk \
  task-openmoko-feed \
"

inherit meta
