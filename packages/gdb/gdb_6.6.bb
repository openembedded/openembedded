require gdb.inc

PR = "r1"

#only append it for glib, not for uclibcc
RRECOMMENDS_gdb_append_linux = " glibc-thread-db "
