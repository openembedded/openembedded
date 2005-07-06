# This package builds the devio program for the build architecture
include devio_${PV}.bb

# Set the installation dir back to the default
sbindir = "${exec_prefix}/sbin"

inherit native
