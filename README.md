# Word Analyzer

## Overview

The **Word Analyzer** is a simple Java-based utility that reads words from an `input.txt` file, validates them, and then processes them according to predefined rules. It’s designed to demonstrate string validation and filtering logic in Java.

---

## Features

- **Input Handling**: Reads from a file named `input.txt`.
- **Validation**: Ensures all entries are valid strings (non-null, non-empty, alphabetic). It also validates if the input data inside input.txt is string else the whole file 
                  is considered as failed ensuirng the strict validation on input file.
- **Rule-Based Filtering**:
  - Finds words that start with the letter `'M'` or `'m'`.
  - Filters words that are longer than 5 characters.

---

## Example Input (`input.txt`)

```text
Monkey
apple
Mountain
melon
