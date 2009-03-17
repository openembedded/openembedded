#!/bin/sh

@bindir@/qcop QPE/TaskBar "reloadInputMethods()"                                            
@bindir@/qcop QPE/System "linkChanged(QString)" 
