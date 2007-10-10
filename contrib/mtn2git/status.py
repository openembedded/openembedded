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

import pickle

marks = {}
last_mark = 0
mark_file = None
former_heads = {}
same_revisions = {}

def load(status_name):
    global marks, last_mark, mark_file, former_heads, same_revisions
    file = open(status_name, "rb")
    marks = pickle.load(file)
    last_mark = pickle.load(file)
    former_heads = pickle.load(file)
    same_revisions = pickle.load(file)
    file.close()

def store(status_name):
    global marks, last_mark, mark_file, former_heads, same_revisions
    file = open(status_name, "wb")
    pickle.dump(marks, file)
    pickle.dump(last_mark, file)
    pickle.dump(former_heads, file)
    pickle.dump(same_revisions, file)
    file.close()
