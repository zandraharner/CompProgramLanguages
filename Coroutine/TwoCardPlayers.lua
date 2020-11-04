numRounds = 3
playerAwintimes = 0
playerBwintimes = 0

function getACard()
  cardindex = math.random(13) -- generate a number between 1 and 13
  if (cardindex <=10) then
    if (cardindex == 1) then
       return cardindex, 'A'
    else
      return cardindex, tostring(cardindex)
    end
  else 
     if (cardindex == 11)
     then return cardindex, 'J'
     else if (cardindex == 12)
          then return cardindex, 'Q'
          else return cardindex, 'K'
          end
     end
  end
end

function playA()
  playerAcards = {}
  playerAcardsStr = ""
  for rounds = 1, numRounds do   
      cardindex, curcard = getACard()
      print(curcard)
      table.insert(playerAcards, curcard)
      playerAcardsStr = playerAcardsStr .. " " .. curcard
      coroutine.yield(cardindex, curcard)  -- return coroutine execution status, cardindex, and curcard
  end
  print("PlayerA cards are: " .. playerAcardsStr)
  return playerAcardsStr
end

function playB()
  playerBcards = {}
  playerBcardsStr = ""
  for rounds = 1, numRounds do   
      cardindex, curcard = getACard()
      print(curcard)
      table.insert(playerBcards,curcard)
      playerBcardsStr = playerBcardsStr .. " " .. curcard
      coroutine.yield(cardindex, curcard)  -- return coroutine execution status, cardindex, and curcard
  end
  print("PlayerB cards are: " .. playerBcardsStr)
  return playerBcardsStr
end

playerA = coroutine.create(playA)
playerB = coroutine.create(playB)

function updateScore(indexA, indexB)
    if (indexA > indexB) then
        playerAwintimes = playerAwintimes + 1
    else 
      if (indexA < indexB) then
         playerBwintimes = playerBwintimes + 1
      end
    end
end

function printScore(rounds)
  io.write(string.format("Round %d finished \n", rounds))
  io.write("***************** \n")
  io.write(string.format("PlayerA (Win: %d) vs PlayerB(Win: %d)\n",  playerAwintimes, playerBwintimes))
  if (playerAwintimes > playerBwintimes)
  then print("Player A Win!!!")
  else if (playerAwintimes < playerBwintimes)
       then print("Player B Win!!!")
       else print("Player A and B tie!!!")
       end
  end
end

for rounds = 1, numRounds do
    statusPlayerA, indexA = coroutine.resume(playerA) -- multiple assignment
    statusPlayerB, indexB = coroutine.resume(playerB) -- multiple assignment
    print(statusPlayerA)  -- statusPlayerA is the execution status of coroutine playerA
    print(statusPlayerB)  -- statusPlayerB is the exeuction status of coroutine playerB
    updateScore(indexA, indexB)
    printScore(rounds)       
end

statusA, playerAcardsStr = coroutine.resume(playerA)
statusB, playerBcardsStr = coroutine.resume(playerB)
print(statusA)
print(statusB)
print(playerAcardsStr)
print(playerBcardsStr)
finalStatusA = coroutine.resume(playerA)
print("finalStatusA = " .. tostring(finalStatusA))
