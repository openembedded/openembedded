#!/usr/bin/env python

"""
  Copyright (C) 2006, 2007 Holger Hans Peter Freyther

  Permission is hereby granted, free of charge, to any person obtaining a copy
  of this software and associated documentation files (the "Software"), to deal
  in the Software without restriction, including without limitation the rights
  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
  copies of the Software, and to permit persons to whom the Software is
  furnished to do so, subject to the following conditions:

  The above copyright notice and this permission notice shall be included in
  all copies or substantial portions of the Software.

  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
  THE SOFTWARE.
"""

#############
#
# Use: This tool can merge one git-branch back to one branch in monotone
#
# Discussion:
#   Merging from git to a monotone branch. Currently I see two modes which
#   should be supported.
#
#    a) linear development. Only a couple of changes are done on top of the
#       branch and nothing get merged. In this case we can merge everything
#       back and each rev gets a cert with the branch.
#       This should be possible using programs like git-rebase.
#    b) we have merges inside our git-rev-list history. This means we need to
#       merge every revision and can't attach any branch certs to the revision.
#       And once we are done with this we will create a propagate like commit
#       entry and we can give that new revision a cert with the branch name.
#
#       This means working in git is treated like a branch!
#
#       One difficulty is with git. This propagate like commit will create a new revision
#       in monotone but none in git as both trees/manifests are the same. So what we have
#       to make sure is to use the latest mtn revision for a given mark/git revision. This
#       is where mtn2git.py needs to help. We will save a list of mtn revisions that have the
#       same git version and then will read every of them and check the branch certs and will
#       use the one matching our target branch!
#############
