include antlr_${PV}.bb
inherit native

# A native antlr would need a native java virtual machine..
# eww. -CL
DEPENDS = "virtual/java-native"
RDEPENDS= "virtual/java-native"
BROKEN = "1"
