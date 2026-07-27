# DSA Profile Analysis & Interview Roadmap
*Prepared as an honest, data-driven review — not a motivational pep talk.*

---

## 1. Overall DSA Level

**Level: Beginner → Early Intermediate**
**Confidence Score: 3.5 / 10**

Why:
- 81 total problems solved, but **63 are Easy (77.8%)**, 17 Medium (21%), and only **1 Hard (1.2%)**.
- A genuinely "Intermediate" LeetCode profile for product-company interviews usually looks like 40–50% Medium and 5–10% Hard. You're currently inverted — most of your reps are on the lowest-difficulty tier.
- Submission accuracy is decent (96 accepted / 112 total ≈ 86%), which tells me you're not guessing wildly — but it also suggests you're mostly solving problems within your comfort zone rather than struggling productively on harder ones.
- The **tag distribution is misleading if read at face value**. For example, "Dynamic Programming: 10" sounds respectable, but with only 17 Medium and 1 Hard problem *total* in your entire profile, most of those 10 DP-tagged problems are almost certainly Easy-difficulty DP (Climbing Stairs, Fibonacci, House Robber I) — not real state-transition DP. Same logic applies to Monotonic Stack (4) and Trie (1).

**Bottom line:** You have built genuine fundamentals (arrays, strings, basic hashing, basic binary search). You have **not yet built pattern-recognition depth**, which is what interviews actually test.

---

## 2. Strength Analysis

Ranked by volume + what it reveals:

| Rank | Topic | Solved | What it reveals |
|---|---|---|---|
| 1 | Array | 54 | Comfortable with iteration, indexing, in-place ops. This is your base layer — good. |
| 2 | Two Pointers | 15 | Real pattern recognition starting to form (this is a *good* sign — it's an actual technique, not just a data structure). |
| 2 | String | 15 | Solid with parsing/manipulation basics. |
| 4 | Hash Table | 14 | You understand O(1) lookup tradeoffs — this is a core interview skill and a genuine strength. |
| 4 | Binary Search | 14 | Good — but "14 solved" combined with "1 Hard total" strongly suggests these are mostly the basic search-in-sorted-array variant, not the harder "binary search on the answer" pattern that FAANG interviews love. |
| 6 | Stack | 13 | Reasonable — but only 4 are Monotonic Stack, which is the version that actually shows up in interviews (next greater element, stock span, histogram). |
| 7 | Math | 11 | Fine as a supporting skill, rarely the main topic in interviews. |
| 8 | Sorting | 8 | Adequate; sorting-as-a-subroutine is expected knowledge, not a differentiator. |
| 9 | Greedy | 7 | Thin. Greedy problems are notoriously hard to identify without more reps. |

**What your statistics reveal overall:** You've been solving in "breadth-first, easy-first" mode — likely working through curated beginner lists (Array → String → Hash Table → Two Pointers) sequentially, rather than targeting interview-frequency patterns. That's a normal and fine phase 1. But it's phase 1, not phase 3.

---

## 3. Weakness Analysis

### Critically underrepresented (interview-essential, near-zero exposure):
- **Graphs: 0 problems, no tag at all.** This is your single biggest gap. Every product-company interview loop has meaningful graph probability (BFS/DFS on grid or graph, shortest path, cycle detection).
- **Heap / Priority Queue: 0 problems.** No tag exists. Top-K, merge-K-lists, scheduling problems are unsolvable without this.
- **Backtracking: 0 problems.** No tag. Subsets, permutations, N-Queens, combination sum — a full category missing.
- **Sliding Window: 0 explicit reps.** Extremely high-frequency pattern (substring problems, max sum subarray of size k) and you have no dedicated exposure.
- **Union Find: 0 problems.**
- **Topological Sort: 0 problems.**
- **Segment Tree / Prefix Sum: 0 problems** (no Prefix Sum tag at all — this is a shockingly common easy-to-medium pattern to be missing).
- **Trees: only 6 combined** (Tree: 3, Binary Tree: 3). Tree traversal, BST properties, LCA, tree DP are all major interview staples and you have almost no reps.
- **Linked List: only 3.** Reversal, cycle detection, merge patterns — thin.
- **BFS: 1. DFS: 3.** These are the *foundation* for graphs/trees/backtracking, and they're barely touched — this explains why graphs and backtracking are at zero: you haven't built the traversal primitives yet.

### Red Flags
1. **Zero graph exposure with a placement season starting in weeks.** This is the #1 fixable risk right now.
2. **DP tag count (10) is inflated relative to your Hard/Medium count (18 combined).** You likely don't yet have real 2D DP / state-transition fluency — this needs verification, not assumption.
3. **112 total submissions for 81 solved problems** is a healthy attempt ratio, but the **low absolute volume** (81 problems in what appears to be a multi-month effort) suggests pace needs to increase significantly before August.
4. **No Sliding Window, no Prefix Sum** — these are "free points" patterns in easy-medium interview questions, and skipping them is a quick, high-ROI fix.

---

## 4. Interview Readiness by Company

Percentages reflect *DSA-round readiness only*, based purely on this profile (not aptitude, HR, or communication rounds).

| Company | Readiness | Notes |
|---|---|---|
| TCS | 80% | DSA bar is low; your aptitude/logic prep matters more here than LeetCode depth. |
| Infosys | 78% | Similar — coding round is usually easy-medium, well within your current range. |
| Wipro | 78% | Same tier as TCS/Infosys. |
| Cognizant | 75% | Slightly more coding-round weight, still manageable. |
| Accenture | 72% | Coding rounds trend easy; you're in range. |
| Capgemini | 70% | Comparable to Accenture. |
| Deloitte (tech roles) | 55% | Tech-consulting roles sometimes probe SQL/OOD alongside DSA — moderate risk. |
| Oracle | 45% | Oracle's coding bar is meaningfully higher than service companies; expect Medium-heavy rounds. |
| IBM | 50% | Depends heavily on role (dev vs. consulting); assume Medium-level DSA. |
| Amazon | 20% | Amazon interviews are Medium/Hard-heavy with strong emphasis on trees, graphs, heaps, and DP — all current gaps. |
| Microsoft | 20% | Similar bar to Amazon; also tests core CS fundamentals (OS, OOD) beyond DSA. |
| Google | 8% | Google's bar is the highest on this list — near-flawless Medium/Hard execution, strong graph/DP fluency required. Currently far off. |
| Adobe | 18% | Comparable to Amazon-tier difficulty. |
| Atlassian | 15% | Strong DSA + system design emphasis even for entry roles. |
| Walmart Global Tech | 25% | Slightly more accessible than Amazon/Google but still Medium-heavy. |
| Samsung R&D | 30% | Coding rounds are rigorous but slightly more forgiving than big tech. |
| Goldman Sachs (tech) | 25% | Strong DSA + CS fundamentals + some quant/logic. |
| JPMorgan Chase | 30% | DSA bar is moderate; more forgiving than Goldman. |
| Morgan Stanley | 28% | Similar tier to JPMorgan. |
| Visa | 25% | Product-company-adjacent bar; Medium-heavy rounds. |

**Reading this table correctly:** You are close to ready for the service-based tier (TCS/Infosys/Wipro/Cognizant/Accenture/Capgemini) *today*. For product-based and fintech companies, you have real work ahead — but with a focused roadmap, an 8–12 week runway is enough to move these numbers meaningfully, especially for Amazon/Adobe/Walmart-tier bars.

---

## 5. Pattern Coverage

| Pattern | Status | Rating |
|---|---|---|
| Two Pointers | 15 solved | **Moderate** |
| Sliding Window | 0 explicit | **Not Started** |
| Binary Search | 14 solved | **Moderate** |
| Prefix Sum | 0 | **Not Started** |
| Hashing | 14 solved | **Moderate** |
| Monotonic Stack | 4 solved | **Weak** |
| BFS | 1 solved | **Not Started** |
| DFS | 3 solved | **Weak** |
| Backtracking | 0 | **Not Started** |
| Dynamic Programming | 10 solved (likely mostly Easy) | **Weak** |
| Union Find | 0 | **Not Started** |
| Topological Sort | 0 | **Not Started** |
| Heap | 0 | **Not Started** |
| Graph | 0 | **Not Started** |
| Trie | 1 solved | **Not Started** |
| Segment Tree | 0 | **Not Started** |
| Greedy | 7 solved | **Weak** |
| Bit Manipulation | 4 solved | **Weak** |

**Summary:** 3 patterns Moderate, 6 Weak, 9 Not Started. This is the clearest quantitative picture of where you stand — roughly half the standard interview pattern set hasn't been touched yet.

---

## 6. Missing Topics (Barely Touched or Never Practiced)

- Graph algorithms (BFS/DFS on graphs, Dijkstra, Union-Find, Topological Sort)
- Heaps / Priority Queues (Top-K, K-way merge, scheduling)
- Backtracking (subsets, permutations, N-Queens, Sudoku-style)
- Sliding Window (fixed and variable size)
- Prefix Sum / Difference Arrays
- Tree algorithms beyond basic traversal (LCA, diameter, tree DP, BST validation/construction)
- Segment Tree / Fenwick Tree (lower priority — mostly Hard-tier, revisit later)
- Linked List manipulation (reversal, cycle detection, merge, LRU cache design)
- Advanced DP (2D DP, knapsack family, interval DP, digit DP)
- Trie (only 1 problem — needed for word search/autocomplete-style questions)

---

## 7. Blind Spots (Inferred, Not Just Missing)

Based on the *pattern* of your statistics — not just topic absence:

1. **You likely don't yet think in terms of "which pattern does this problem map to?"** High Easy-tier volume with low Medium/Hard volume usually means problems were solved by direct implementation rather than pattern recognition. Interviews test the latter.
2. **You probably haven't built real recursion-to-DP intuition.** DFS (3) and Recursion (3) are both very low, and DP requires comfort with recursive thinking *before* it can be optimized with memoization/tabulation. This is likely your single largest conceptual gap.
3. **You likely haven't practiced explaining time/space complexity trade-offs out loud**, since your solve pattern shows no signs of revisiting problems with multiple approaches (submission-to-solve ratio is close to 1:1 per difficulty tier, suggesting single-pass solving rather than optimization iteration).
4. **Graph mental model is probably absent**, not just "graph problems unsolved" — meaning even reading a graph-shaped problem might not immediately trigger "this is a graph."

---

## 8. Personalized Roadmap (Today → Interview-Ready)

### Phase 0 (Weeks 1–2): Foundation Repair
- **Recursion & DFS/BFS fundamentals** — 5 Easy, 5 Medium
- **Linked List core patterns** — 5 Easy, 5 Medium
- **Prefix Sum** — 5 Easy, 3 Medium
- *Milestone:* Comfortable writing recursive tree/graph traversal from scratch, no reference.

### Phase 1 (Weeks 3–4): Core Pattern Building
- **Sliding Window** — 6 Easy, 6 Medium
- **Trees (traversal, BST, LCA)** — 5 Easy, 8 Medium
- **Binary Search on Answer (advanced variant)** — 3 Easy, 6 Medium
- *Milestone:* Can identify sliding window vs. two pointers vs. prefix sum instantly from problem statement.

### Phase 2 (Weeks 5–6): Graphs + Heaps
- **Graph BFS/DFS, Union-Find, Topological Sort** — 5 Easy, 10 Medium, 2 Hard
- **Heap / Priority Queue (Top-K, merge-K)** — 4 Easy, 6 Medium
- *Milestone:* Can solve "number of islands," "course schedule," "top K frequent" without hints.
- **Start light contest participation here** (LeetCode Weekly, even if you only solve 1–2 problems — the goal is speed and pressure exposure, not ranking).

### Phase 3 (Weeks 7–8): DP + Backtracking
- **Backtracking (subsets, permutations, combination sum)** — 4 Easy, 8 Medium
- **1D & 2D Dynamic Programming** — 4 Easy, 12 Medium, 3 Hard
- **Greedy (revisit with pattern lens)** — 3 Medium
- *Milestone:* Can solve knapsack-family and interval DP problems with a clear recurrence relation written before coding.
- **Start mock interviews here** (peer mocks or platforms like Pramp/interviewing.io) — you now have enough pattern coverage for mocks to be productive rather than discouraging.

### Phase 4 (Weeks 9+, ongoing): Depth & Speed
- Revisit weak patterns (Monotonic Stack, Bit Manipulation, Trie) — 3–5 Medium each
- Weekly timed contests (mandatory from here on)
- 2 mock interviews/week
- Begin company-specific problem sets (Amazon/Microsoft/Google tagged lists on LeetCode Premium if accessible)

---

## 9. 8-Week Plan (Daily Goals)

*Assumes ~1.5–2 hours/day. Adjust volume down if your placement exam prep (aptitude/verbal) needs more time this month — but don't drop DSA to zero on any day.*

| Week | Mon–Fri (daily) | Weekend |
|---|---|---|
| 1 | 1 Recursion/DFS problem + review 1 old Easy solution for optimization | 2 Linked List problems + write summary notes on recursion patterns |
| 2 | 1 Linked List or Prefix Sum problem | 2 Prefix Sum problems + revisit Week 1 problems cold (no notes) |
| 3 | 1 Sliding Window problem | 2 Tree traversal problems |
| 4 | 1 Tree/BST problem | 2 Binary-Search-on-Answer problems + re-solve 2 Week 3 problems |
| 5 | 1 Graph BFS/DFS problem | 2 Graph problems (Union-Find or Topo Sort) + 1 LeetCode Weekly Contest |
| 6 | 1 Heap problem | 2 Graph/Heap mixed problems + 1 Contest |
| 7 | 1 Backtracking problem | 2 DP problems + 1 mock interview (45 min) |
| 8 | 1 DP problem | 2 DP problems + 1 mock interview + full review of all patterns solved |

**Non-negotiable habit:** After every problem, spend 2 minutes writing (in your own words) *which pattern this was* and *what the trigger phrase in the problem statement was*. This is what converts volume into pattern recognition — and it's the step most self-taught prep skips.

---

## 10. What Your Profile Should Look Like for Amazon / Microsoft / Adobe / Atlassian / Google

| Metric | Your Current Profile | Target for Amazon/Microsoft/Adobe/Atlassian | Target for Google |
|---|---|---|---|
| Total solved | 81 | 250–350 | 350–450+ |
| Easy % | 78% | ~30% | ~20% |
| Medium % | 21% | ~55% | ~55% |
| Hard % | 1% | ~15% | ~25% |
| Graph problems | 0 | 20+ | 30+ |
| DP problems (real Medium/Hard) | ~0 verified | 25+ | 40+ |
| Trees | 6 | 25+ | 35+ |
| Contest participation | None indicated | Occasional | Regular (rating-tracked) |
| Mock interviews before applying | 0 | 8–10 | 15+ |

This gap is real, but it's a volume-and-pattern gap, not a talent gap — your accuracy rate (86%) shows you learn correctly when you engage with a problem. The roadmap above is designed to close this systematically before your product-company application window.

---

## 11. Profile Scores (out of 10)

| Category | Score | Reasoning |
|---|---|---|
| Arrays | 6/10 | Strong volume, but needs harder variants (in-place, O(1) space tricks) |
| Strings | 5/10 | Decent breadth, weak on advanced string algorithms (KMP, pattern matching) |
| Hashing | 5/10 | Good conceptual base, needs harder application (grouping, frequency-based DP hybrids) |
| Trees | 2/10 | Severely underrepresented for interview weight this topic carries |
| Graphs | 0.5/10 | Essentially unstarted |
| Dynamic Programming | 2/10 | Tag count is misleading; real DP fluency likely near zero |
| Linked Lists | 2/10 | Minimal exposure |
| Binary Search | 5/10 | Solid on basics, untested on "search on answer space" variant |
| Greedy | 3/10 | Pattern recognition not yet developed |
| Math | 4/10 | Adequate as a support skill |
| **Overall DSA** | **3/10** | Foundations solid, pattern coverage thin, volume low for timeline |
| **Interview Readiness (product companies)** | **2.5/10** | Real gap; service companies significantly higher (~7/10) |
| **Consistency** | **5/10** | Good accuracy suggests real engagement, but total volume/timeframe suggests inconsistent or low-frequency practice |

---

## 12. Final Verdict — As a FAANG Interviewer

**Would I shortlist you based solely on this profile? No — not yet, and I want to be precise about why, because it's fixable.**

If I'm screening resumes/profiles for an Amazon or Microsoft SDE-1 role, I'm pattern-matching for signal that a candidate can handle Medium/Hard problems under pressure across multiple categories — especially graphs, trees, and DP, since those show up disproportionately in loops. Your profile shows **77.8% Easy-tier solving and zero graph exposure**, which reads as "early in the DSA journey," not "interview-ready." The 1 Hard problem out of 81 is the single number that would concern me most — it suggests you haven't yet been tested against genuinely difficult constraint-satisfaction problems.

That said — and this matters — **I would not write you off**. Your 86% acceptance-to-submission ratio and the fact that Two Pointers (an actual *technique*, not just a data structure) already shows real volume tells me you're learning correctly, just not yet broadly. This is a classic "phase 1 complete, phase 2 not started" profile. Service-based companies (TCS, Infosys, Wipro, etc.) would very likely shortlist you today — their DSA bar is calibrated differently.

**My honest recommendation:** Don't apply to Amazon/Google/Adobe-tier companies yet if you can avoid it — burn a low-stakes application (a smaller product company or a service company) first, use it as calibration, and spend the next 8 weeks executing the roadmap above. Graphs, trees, DP, and backtracking are your highest-leverage gaps — closing even 60% of them would move your product-company readiness from ~20% to something in the 45–55% range, which is a realistic, defensible target before August.
